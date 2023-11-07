package com.brijframework.production.cust.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchase;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseAdditional;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchasePayment;
import com.brijframework.production.cust.event.StockEvent;
import com.brijframework.production.cust.mapper.CustProductPurchaseRequestMapper;
import com.brijframework.production.cust.mapper.CustProductPurchaseResponseMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustProductPurchaseAdditionalRepository;
import com.brijframework.production.cust.repository.CustProductPurchaseItemRepository;
import com.brijframework.production.cust.repository.CustProductPurchasePaymentRepository;
import com.brijframework.production.cust.repository.CustProductPurchaseRepository;
import com.brijframework.production.cust.repository.CustProductRepository;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseAdditional;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseItemRequest;
import com.brijframework.production.cust.rest.purchase.CustProductPurchasePayment;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseRequest;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseResponse;
import com.brijframework.production.cust.service.CustProductPurchaseService;
import com.brijframework.production.cust.service.CustProductStockService;
import com.brijframework.production.util.CommanUtil;

@Service
public class CustProductPurchaseServiceImpl implements CustProductPurchaseService {
	
	private static final String CPL = "CPL";
	
	@Autowired
    private KafkaTemplate<String, StockEvent> stockEventTemplate;

	@Autowired
	private CustProductPurchaseRepository custProductPurchaseRepository;
	
	@Autowired
	private CustProductPurchaseItemRepository custProductPurchaseItemRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustProductRepository custProductRepository;
	
	@Autowired
	private CustProductPurchaseRequestMapper custProductPurchaseRequestMapper;
	
	@Autowired
	private CustProductPurchaseResponseMapper custProductPurchaseResponseMapper; 
	
	@Autowired
	private CustProductPurchasePaymentRepository custProductPurchasePaymentRepository;
	
	@Autowired
	private CustProductPurchaseAdditionalRepository custProductPurchaseAdditionalRepository;
	
	@Autowired
	private CustProductStockService custProductStockService;
	
	@Override
	public CustProductPurchaseResponse saveProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductPurchase eoCustProductPurchase = saveCustProductPurchase(custProductPurchaseRequest, eoCustBusinessApp);
		return custProductPurchaseResponseMapper.mapToDTO(eoCustProductPurchase);
	}

	private EOCustProductPurchase saveCustProductPurchase(CustProductPurchaseRequest custProductPurchaseRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		List<CustProductPurchaseItemRequest> custProductPurchaseItemList = custProductPurchaseRequest.getCustProductPurchaseItemList();
		List<CustProductPurchaseAdditional> custProductAdditionalList = custProductPurchaseRequest.getCustProductPurchaseAdditionalList();
		List<CustProductPurchasePayment> custProductPaymentList = custProductPurchaseRequest.getCustProductPurchasePaymentList();
		custProductPurchaseRequest.setCustProductPurchaseItemList(null);
		custProductPurchaseRequest.setCustProductPurchaseAdditionalList(null);
		custProductPurchaseRequest.setCustProductPurchasePaymentList(null);
		
		EOCustProductPurchase eoCustProductPurchase = custProductPurchaseRequestMapper.mapToDAO(custProductPurchaseRequest);
		eoCustProductPurchase.setSupplierId(custProductPurchaseRequest.getSupplierId());
		if(custProductPurchaseRequest.getId()==null) {
			eoCustProductPurchase.setIdenNo(CommanUtil. getIdenNo(CPL));
		}
		eoCustProductPurchase.setCustBusinessApp(eoCustBusinessApp);
		eoCustProductPurchase = custProductPurchaseRepository.saveAndFlush(eoCustProductPurchase);
		
		for(EOCustProductPurchaseAdditional custProductAdditional: custProductPurchaseRequestMapper.custProductPurchaseAdditionalListDAO(custProductAdditionalList)){
			custProductAdditional.setCustProductPurchase(eoCustProductPurchase);
			custProductPurchaseAdditionalRepository.saveAndFlush(custProductAdditional);
		};
		
		for(EOCustProductPurchasePayment custProductPurchasePayment: custProductPurchaseRequestMapper.custProductPurchasePaymentListDAO(custProductPaymentList)){
			custProductPurchasePayment.setCustProductPurchase(eoCustProductPurchase);
			custProductPurchasePayment.setSupplierId(eoCustProductPurchase.getSupplierId());
			custProductPurchasePaymentRepository.saveAndFlush(custProductPurchasePayment);
		};
		
		for(CustProductPurchaseItemRequest custProductRetailPurchaseUi : custProductPurchaseItemList){
			EOCustProductPurchaseItem eoCustProductRetailPurchase = custProductPurchaseRequestMapper.mapToDAO(custProductRetailPurchaseUi);
			EOCustProduct eoCustProduct = custProductRepository.findById(custProductRetailPurchaseUi.getCustProductId()).orElse(null);
			eoCustProductRetailPurchase.setCustProduct(eoCustProduct);
			eoCustProductRetailPurchase.setCustProductPurchase(eoCustProductPurchase);
			EOCustProductPurchaseItem saveCustProductRetailPurchase=custProductPurchaseItemRepository.saveAndFlush(eoCustProductRetailPurchase);
			
			stockEventTemplate.send("STOCK_EVENT", new StockEvent(saveCustProductRetailPurchase.getId(),eoCustProduct.getId()));
			
			custProductStockService.saveCustProductStocksBackground(saveCustProductRetailPurchase); 
		}
		return eoCustProductPurchase;
	}

	@Override
	public CustProductPurchaseResponse updateProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductPurchase eoCustProductPurchase = saveCustProductPurchase(custProductPurchaseRequest, eoCustBusinessApp);
		return custProductPurchaseResponseMapper.mapToDTO(eoCustProductPurchase);
	}

	@Override
	public List<CustProductPurchaseResponse> getProductPurchaseList(long custAppId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findAllByCustBusinessAppId(custAppId));
	}

	@Override
	public CustProductPurchaseResponse getProductPurchase(long custAppId, String typeId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findByCustBusinessAppIdAndTypeId(custAppId, typeId));
	}

	@Override
	public List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.filterProductPurchaseList(custAppId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteProductPurchase(long custAppId, Long id) {
		custProductPurchaseRepository.deleteById(id);
		return true;
	}

}
