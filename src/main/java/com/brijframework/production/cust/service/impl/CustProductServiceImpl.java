package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.mapper.CustProductRequestMapper;
import com.brijframework.production.cust.mapper.CustProductResponseMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustProductRepository;
import com.brijframework.production.cust.rest.CustProductRequest;
import com.brijframework.production.cust.rest.CustProductResponse;
import com.brijframework.production.cust.service.CustProductService;
import com.brijframework.production.util.CommanUtil;

@Service
public class CustProductServiceImpl implements CustProductService {
	
	private static final String PO = "PO";

	@Autowired
	CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	CustProductRepository custProductRepository;
	
	@Autowired
	CustProductRequestMapper custProductRequestMapper;
	
	@Autowired
	CustProductResponseMapper custProductResponseMapper;
	
	@Override
	public CustProductResponse saveProduct(long custAppId, CustProductRequest custProductRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		return saveProduct(findById.get(), custProductRequest);
	}
	
	@Override
	public CustProductResponse saveProduct(CustProductRequest custProductRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custProductRequest.getCustBusinessAppId());
		if(!findById.isPresent()) {
			return null;
		}
		return saveProduct(findById.get(), custProductRequest);
	}
	
	@Override
	public CustProductResponse saveProduct(EOCustBusinessApp custBusinessApp,CustProductRequest custProductRequest) {
		EOCustProduct eoProduct=custProductRequestMapper.mapToDAO(custProductRequest);
		eoProduct.setCustBusinessApp(custBusinessApp);
		eoProduct.setIdenNo(CommanUtil. getIdenNo(PO));
		custProductRepository.save(eoProduct);
		return custProductResponseMapper.mapToDTO(eoProduct);
	}
	
	@Override
	public CustProductResponse updateProduct(long custAppId, CustProductRequest custProductRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoInventoryApp = findById.get();
		Optional<EOCustProduct> findProduct = custProductRepository.findById(custProductRequest.getId());
		if(!findProduct.isPresent()) {
			System.out.println("NOT FOUND");
			return null;
		}
		EOCustProduct eoGlobalProduct = findProduct.get();
		BeanUtils.copyProperties(custProductRequest, eoGlobalProduct);
		eoGlobalProduct.setCustBusinessApp(eoInventoryApp);
        eoGlobalProduct.setIdenNo(StringUtils.isEmpty(eoGlobalProduct.getIdenNo()) ? CommanUtil. getIdenNo(PO) : eoGlobalProduct.getIdenNo());
        //eoGlobalProduct.setIdenNo(getIdenNo());
		custProductRepository.save(eoGlobalProduct);
		return custProductResponseMapper.mapToDTO(eoGlobalProduct);
	}
	
	@Override
	public CustProductResponse getProduct(long id) {
		return custProductResponseMapper.mapToDTO(custProductRepository.getOne(id));
	}

	@Override
	public List<CustProductResponse> getProductList(long inventoryAppId) {
		return custProductResponseMapper.mapToDTO(custProductRepository.findAllByCustBusinessAppId(inventoryAppId));
	}

	@Override
	public CustProductResponse getProduct(long inventoryAppId, String typeId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
