package com.brijframework.production.cust.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.entities.sales.EOCustProductSale;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleAdditional;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;
import com.brijframework.production.cust.entities.sales.EOCustProductSalePayment;
import com.brijframework.production.cust.mapper.CustProductSaleRequestMapper;
import com.brijframework.production.cust.mapper.CustProductSaleResponseMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustProductRepository;
import com.brijframework.production.cust.repository.CustProductSaleAdditionalRepository;
import com.brijframework.production.cust.repository.CustProductSaleItemRepository;
import com.brijframework.production.cust.repository.CustProductSalePaymentRepository;
import com.brijframework.production.cust.repository.CustProductSaleRepository;
import com.brijframework.production.cust.rest.sale.CustProductSaleAdditional;
import com.brijframework.production.cust.rest.sale.CustProductSaleItemRequest;
import com.brijframework.production.cust.rest.sale.CustProductSalePayment;
import com.brijframework.production.cust.rest.sale.CustProductSaleRequest;
import com.brijframework.production.cust.rest.sale.CustProductSaleResponse;
import com.brijframework.production.cust.service.CustProductSaleService;
import com.brijframework.production.cust.service.CustProductStockService;
import com.brijframework.production.util.CommanUtil;

@Service
public class CustProductSaleServiceImpl implements CustProductSaleService {
	
	
	private static final String CSL = "CSL";

	@Autowired
	private CustProductSaleRepository custProductSaleRepository;
	
	@Autowired
	private CustProductSaleItemRepository custProductRetailSaleRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustProductRepository custProductRepository;
	
	@Autowired
	private CustProductSaleRequestMapper custProductSaleRequestMapper;
	
	@Autowired
	private CustProductSaleResponseMapper custProductSaleResponseMapper; 
	
	@Autowired
	private CustProductSalePaymentRepository custProductSalePaymentRepository;
	
	@Autowired
	private CustProductSaleAdditionalRepository custProductSaleAdditionalRepository;
	
	@Autowired
	private CustProductStockService custProductStockService;
	
	@Override
	public CustProductSaleResponse saveProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductSale eoCustProductSale = saveCustProductSale(custProductSaleRequest, eoCustBusinessApp);
		return custProductSaleResponseMapper.mapToDTO(eoCustProductSale);
	}

	private EOCustProductSale saveCustProductSale(CustProductSaleRequest custProductSaleRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		List<CustProductSaleItemRequest> custProductSaleItemList = custProductSaleRequest.getCustProductSaleItemList();
		List<CustProductSaleAdditional> custProductAdditionalList = custProductSaleRequest.getCustProductSaleAdditionalList();
		List<CustProductSalePayment> custProductPaymentList = custProductSaleRequest.getCustProductSalePaymentList();
		custProductSaleRequest.setCustProductSaleItemList(null);
		custProductSaleRequest.setCustProductSaleAdditionalList(null);
		custProductSaleRequest.setCustProductSalePaymentList(null);
		
		EOCustProductSale eoCustProductSale = custProductSaleRequestMapper.mapToDAO(custProductSaleRequest);
		eoCustProductSale.setCustomerId(custProductSaleRequest.getCustomerId());
		if(custProductSaleRequest.getId()==null) {
			eoCustProductSale.setIdenNo(CommanUtil. getIdenNo(CSL));
		}
		eoCustProductSale.setCustBusinessApp(eoCustBusinessApp);
		eoCustProductSale = custProductSaleRepository.saveAndFlush(eoCustProductSale);
		
		for(EOCustProductSaleAdditional custProductAdditional: custProductSaleRequestMapper.custProductSaleAdditionalListDAO(custProductAdditionalList)){
			custProductAdditional.setCustProductSale(eoCustProductSale);
			custProductSaleAdditionalRepository.saveAndFlush(custProductAdditional);
		};
		
		for(EOCustProductSalePayment custProductSalePayment: custProductSaleRequestMapper.custProductSalePaymentListDAO(custProductPaymentList)){
			custProductSalePayment.setCustProductSale(eoCustProductSale);
			custProductSalePayment.setCustomerId(eoCustProductSale.getCustomerId());
			custProductSalePaymentRepository.saveAndFlush(custProductSalePayment);
		};
		
		for(CustProductSaleItemRequest custProductRetailSaleUi : custProductSaleItemList){
			EOCustProductSaleItem eoCustProductRetailSale = custProductSaleRequestMapper.mapToDAO(custProductRetailSaleUi);
			EOCustProduct eoCustProduct = custProductRepository.findById(custProductRetailSaleUi.getCustProductId()).orElse(null);

			eoCustProductRetailSale.setCustProduct(eoCustProduct);

			eoCustProductRetailSale.setCustProductSale(eoCustProductSale);
			
			EOCustProductSaleItem saveCustProductRetailPurchase= custProductRetailSaleRepository.saveAndFlush(eoCustProductRetailSale);
			custProductStockService.saveCustProductStocksBackground(saveCustProductRetailPurchase); 
		}
		return eoCustProductSale;
	}

	@Override
	public CustProductSaleResponse updateProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductSale eoCustProductSale = saveCustProductSale(custProductSaleRequest, eoCustBusinessApp);
		return custProductSaleResponseMapper.mapToDTO(eoCustProductSale);
	}

	@Override
	public List<CustProductSaleResponse> getProductSaleList(long custAppId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findAllByCustBusinessAppId(custAppId));
	}

	@Override
	public CustProductSaleResponse getProductSale(long custAppId, String typeId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findByCustBusinessAppIdAndTypeId(custAppId, typeId));
	}

	@Override
	public List<CustProductSaleResponse> filterProductSaleList(long custAppId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.filterProductSaleList(custAppId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteProductSale(long custAppId, Long id) {
		custProductSaleRepository.deleteById(id);
		return true;
	}

}
