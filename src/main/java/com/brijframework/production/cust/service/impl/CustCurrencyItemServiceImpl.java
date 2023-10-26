package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustCurrencyItem;
import com.brijframework.production.cust.mapper.CustCurrencyItemRequestMapper;
import com.brijframework.production.cust.mapper.CustCurrencyItemResponseMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustCurrencyItemRepository;
import com.brijframework.production.cust.rest.CustCurrencyItemRequest;
import com.brijframework.production.cust.rest.CustCurrencyItemResponse;
import com.brijframework.production.cust.service.CustCurrencyItemService;

@Service
public class CustCurrencyItemServiceImpl implements CustCurrencyItemService {
	
	@Autowired
	CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	CustCurrencyItemRepository custCurrencyItemRepository;
	
	@Autowired
	CustCurrencyItemRequestMapper custCurrencyItemRequestMapper;
	
	@Autowired
	CustCurrencyItemResponseMapper custCurrencyItemResponseMapper;
	
	@Override
	public CustCurrencyItemResponse saveCurrencyItem(long custAppId, CustCurrencyItemRequest custCurrencyItemRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		return saveCurrencyItem(findById.get(), custCurrencyItemRequest);
	}
	
	@Override
	public CustCurrencyItemResponse saveCurrencyItem(EOCustBusinessApp eoCustBusinessApp,CustCurrencyItemRequest custCurrencyItemRequest) {
		EOCustCurrencyItem eoCustCurrencyItem=custCurrencyItemRequestMapper.mapToDAO(custCurrencyItemRequest);
		eoCustCurrencyItem.setCustBusinessApp(eoCustBusinessApp);
		custCurrencyItemRepository.save(eoCustCurrencyItem);
		return custCurrencyItemResponseMapper.mapToDTO(eoCustCurrencyItem);
	}

	@Override
	public CustCurrencyItemResponse getCurrencyItem(long custAppId, long id) {
		return custCurrencyItemResponseMapper.mapToDTO(custCurrencyItemRepository.getOne(id));
	}

	@Override
	public List<CustCurrencyItemResponse> findAllByType(long custAppId, String typeId) {
		return custCurrencyItemResponseMapper.mapToDTO(custCurrencyItemRepository.findAllByType(custAppId,typeId));
	}

	@Override
	public List<CustCurrencyItemResponse> getCurrencyItemList(long custAppId) {
		return custCurrencyItemResponseMapper.mapToDTO(custCurrencyItemRepository.findAllByCustAppId(custAppId));
	}

	@Override
	public boolean deleteCurrencyItem(long custAppId, Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
