package com.brijframework.production.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;
import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;
import com.brijframework.production.global.mapper.GlobalCurrencyGroupMapper;
import com.brijframework.production.global.repository.GlobalCurrencyGroupRepository;
import com.brijframework.production.global.service.GlobalCurrencyGroupService;

@Service
public class GlobalCurrencyGroupServiceImpl implements GlobalCurrencyGroupService {
	
	@Autowired
	private GlobalCurrencyGroupRepository globalCurrencyGroupRepository;
	
	@Autowired
	private GlobalCurrencyGroupMapper inventoryCurrencyGroupMapper;
	
	@Override
	public UIGlobalCurrencyGroup saveCurrencyGroup(UIGlobalCurrencyGroup unitGroup) {
		EOGlobalCurrencyGroup eoCurrencyGroup=inventoryCurrencyGroupMapper.mapToDAO(unitGroup);
		globalCurrencyGroupRepository.save(eoCurrencyGroup);
		return inventoryCurrencyGroupMapper.mapToDTO(eoCurrencyGroup);
	}

	@Override
	public UIGlobalCurrencyGroup getCurrencyGroup(long id) {
		return inventoryCurrencyGroupMapper.mapToDTO(globalCurrencyGroupRepository.getOne(id));
	}

	@Override
	public List<UIGlobalCurrencyGroup> getCurrencyGroupList() {
		return inventoryCurrencyGroupMapper.mapToDTO(globalCurrencyGroupRepository.findAll());
	}
	
	@Override
	public List<UIGlobalCurrencyGroup> getCurrencyGroupList(RecordStatus dataStatus) {
		List<EOGlobalCurrencyGroup> findAllByStatus = globalCurrencyGroupRepository.getCurrencyGroupListByStatus(dataStatus.getStatusIds());
		return inventoryCurrencyGroupMapper.mapToDTO(findAllByStatus);
	}

	@Override
	public List<UIGlobalCurrencyGroup> getCurrencyGroup(String typeId) {
		return inventoryCurrencyGroupMapper.mapToDTO(globalCurrencyGroupRepository.findAllByTypeId(typeId));
	}

	@Override
	public boolean deleteCurrencyGroup(Long id) {
		EOGlobalCurrencyGroup eoGlobalCurrencyGroup = globalCurrencyGroupRepository.getOne(id);
		eoGlobalCurrencyGroup.setRecordState(RecordStatus.DACTIVETED.getStatus());
		globalCurrencyGroupRepository.save(eoGlobalCurrencyGroup);
		return true;
	}

}
