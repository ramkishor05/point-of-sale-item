package com.brijframework.production.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.repository.CustProductionAppRepository;
import com.brijframework.production.global.dto.UIGlobalUnitGroup;
import com.brijframework.production.global.entities.EOGlobalUnitGroup;
import com.brijframework.production.global.mapper.GlobalUnitGroupMapper;
import com.brijframework.production.global.mapper.GlobalUnitMapper;
import com.brijframework.production.global.repository.GlobalUnitGroupRepository;
import com.brijframework.production.global.repository.GlobalUnitRepository;
import com.brijframework.production.global.service.GlobalUnitGroupService;

@Service
public class GlobalUnitGroupServiceImpl implements GlobalUnitGroupService {
	
	@Autowired
	CustProductionAppRepository custProductionAppRepository;
	
	@Autowired
	GlobalUnitGroupRepository globalUnitGroupRepository;
	
	@Autowired
	GlobalUnitGroupMapper globalUnitGroupMapper;
	
	@Autowired
	GlobalUnitRepository globalUnitRepository;
	
	@Autowired
	GlobalUnitMapper globalUnitMapper;
	
		
	@Override
	public UIGlobalUnitGroup saveUnitGroup(UIGlobalUnitGroup unitGroup) {
		EOGlobalUnitGroup eoUnitGroup=globalUnitGroupMapper.mapToDAO(unitGroup);
		globalUnitGroupRepository.save(eoUnitGroup);
		return globalUnitGroupMapper.mapToDTO(eoUnitGroup);
	}

	@Override
	public UIGlobalUnitGroup getUnitGroup(long id) {
		return globalUnitGroupMapper.mapToDTO(globalUnitGroupRepository.getOne(id));
	}

	
	@Override
	public List<UIGlobalUnitGroup> getUnitGroupList() {
		return globalUnitGroupMapper.mapToDTO(globalUnitGroupRepository.findAll());
	}

	@Override
	public UIGlobalUnitGroup getUnitGroup(String typeId) {
		return globalUnitGroupMapper.mapToDTO(globalUnitGroupRepository.findAllByTypeId(typeId));
	}

	@Override
	public boolean deleteUnitGroup(Long id) {
		globalUnitGroupRepository.deleteById(id);
		return true;
	}

}
