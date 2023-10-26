package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustUnit;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustUnitItem;
import com.brijframework.production.cust.mapper.CustUnitMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustUnitItemRepository;
import com.brijframework.production.cust.service.CustUnitService;

@Service
public class CustUnitServiceImpl implements CustUnitService {
	
	@Autowired
	CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	CustUnitItemRepository custUnitRepository;
	
	@Autowired
	CustUnitMapper custUnitMapper;

	@Override
	public UICustUnit saveUnit(long custAppId, UICustUnit uiCustUnit) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustUnitItem eoCustUnit = custUnitMapper.mapToDAO(uiCustUnit);
		eoCustUnit.setCustBusinessApp(eoCustBusinessApp);
		eoCustUnit = custUnitRepository.save(eoCustUnit);
		return custUnitMapper.mapToDTO(eoCustUnit);
	}

	@Override
	public UICustUnit updateUnit(long custAppId, Long id, UICustUnit uiCustUnit) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustUnitItem eoCustUnit = custUnitMapper.mapToDAO(uiCustUnit);
		eoCustUnit.setCustBusinessApp(eoCustBusinessApp);
		eoCustUnit = custUnitRepository.save(eoCustUnit);
		return custUnitMapper.mapToDTO(eoCustUnit);
	}

	@Override
	public List<UICustUnit> getUnitList(long custAppId) {
		return custUnitMapper.mapToDTO(custUnitRepository.findByCustAppId(custAppId));
	}

}
