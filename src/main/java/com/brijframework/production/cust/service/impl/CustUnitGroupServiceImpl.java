package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustUnitGroup;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustUnitGroup;
import com.brijframework.production.cust.mapper.CustUnitGroupMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustUnitGroupRepository;
import com.brijframework.production.cust.service.CustUnitGroupService;

@Service
public class CustUnitGroupServiceImpl implements CustUnitGroupService {
	@Autowired
	CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	CustUnitGroupRepository custUnitGroupRepository;
	
	@Autowired
	CustUnitGroupMapper custUnitGroupMapper;


	@Override
	public UICustUnitGroup saveUnitGroup(long custAppId, UICustUnitGroup uiCustUnitGroup) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustUnitGroup eoCustUnitGroup = custUnitGroupMapper.mapToDAO(uiCustUnitGroup);
		eoCustUnitGroup.setCustBusinessApp(eoCustBusinessApp);
		eoCustUnitGroup=custUnitGroupRepository.save(eoCustUnitGroup);
		return custUnitGroupMapper.mapToDTO(eoCustUnitGroup);
	}

	@Override
	public UICustUnitGroup updateUnitGroup(long custAppId, UICustUnitGroup uiCustUnitGroup) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustUnitGroup eoCustUnitGroup = custUnitGroupMapper.mapToDAO(uiCustUnitGroup);
		eoCustUnitGroup.setCustBusinessApp(eoCustBusinessApp);
		eoCustUnitGroup=custUnitGroupRepository.save(eoCustUnitGroup);
		return custUnitGroupMapper.mapToDTO(eoCustUnitGroup);
	}

	@Override
	public List<UICustUnitGroup> getUnitGroupList(long custAppId) {
		return custUnitGroupMapper.mapToDTO(custUnitGroupRepository.findByCustAppId(custAppId));
	}

	@Override
	public List<UICustUnitGroup> getUnitGroupList(long custAppId, String typeId) {
		return custUnitGroupMapper.mapToDTO(custUnitGroupRepository.findByCustAppId(custAppId));
	}

}
