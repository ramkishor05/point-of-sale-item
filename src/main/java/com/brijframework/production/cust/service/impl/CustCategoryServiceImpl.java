package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.mapper.CustCategoryRequestMapper;
import com.brijframework.production.cust.mapper.CustCategoryResponseMapper;
import com.brijframework.production.cust.repository.CustCategoryItemRepository;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.rest.CustCategoryRequest;
import com.brijframework.production.cust.rest.CustCategoryResponse;
import com.brijframework.production.cust.service.CustCategoryService;

@Service
public class CustCategoryServiceImpl implements CustCategoryService {
	
	@Autowired
	CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	CustCategoryItemRepository custCategoryRepository;
	
	@Autowired
	CustCategoryRequestMapper custCategoryRequestMapper;
	
	@Autowired
	CustCategoryResponseMapper custCategoryResponseMapper;
	
	@Override
	public CustCategoryResponse saveCategory(long custAppId, CustCategoryRequest custCategoryRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		return saveCategory(findById.get(), custCategoryRequest);
	}
	
	@Override
	public CustCategoryResponse saveCategory(EOCustBusinessApp eoCustBusinessApp,CustCategoryRequest custCategoryRequest) {
		EOCustCategoryItem eoCustCategory=custCategoryRequestMapper.mapToDAO(custCategoryRequest);
		eoCustCategory.setCustBusinessApp(eoCustBusinessApp);
		custCategoryRepository.save(eoCustCategory);
		return custCategoryResponseMapper.mapToDTO(eoCustCategory);
	}

	@Override
	public CustCategoryResponse getCategory(long custAppId, long id) {
		return custCategoryResponseMapper.mapToDTO(custCategoryRepository.getOne(id));
	}

	@Override
	public List<CustCategoryResponse> findAllByType(long custAppId, String typeId) {
		return custCategoryResponseMapper.mapToDTO(custCategoryRepository.findAllByType(custAppId,typeId));
	}

	@Override
	public List<CustCategoryResponse> getCategoryList(long custAppId) {
		return custCategoryResponseMapper.mapToDTO(custCategoryRepository.findAllByCustAppId(custAppId));
	}

	@Override
	public boolean deleteCategory(long custAppId, Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
