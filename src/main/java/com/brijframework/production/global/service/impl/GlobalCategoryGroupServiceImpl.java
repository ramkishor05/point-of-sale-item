package com.brijframework.production.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.DataStatus;
import com.brijframework.production.global.dto.UIGlobalCategoryGroup;
import com.brijframework.production.global.entities.EOGlobalCategoryGroup;
import com.brijframework.production.global.mapper.GlobalCategoryGroupMapper;
import com.brijframework.production.global.repository.GlobalCategoryGroupRepository;
import com.brijframework.production.global.service.GlobalCategoryGroupService;

@Service
public class GlobalCategoryGroupServiceImpl implements GlobalCategoryGroupService {
	
	@Autowired
	private GlobalCategoryGroupRepository globalCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryGroupMapper inventoryCategoryGroupMapper;
	
	@Override
	public UIGlobalCategoryGroup saveCategoryGroup(UIGlobalCategoryGroup unitGroup) {
		EOGlobalCategoryGroup eoCategoryGroup=inventoryCategoryGroupMapper.mapToDAO(unitGroup);
		globalCategoryGroupRepository.save(eoCategoryGroup);
		return inventoryCategoryGroupMapper.mapToDTO(eoCategoryGroup);
	}

	@Override
	public UIGlobalCategoryGroup getCategoryGroup(long id) {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.getOne(id));
	}

	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroupList() {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.findAll());
	}
	
	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroupList(DataStatus dataStatus) {
		List<EOGlobalCategoryGroup> findAllByStatus = globalCategoryGroupRepository.getCategoryGroupListByStatus(dataStatus.getStatusIds());
		System.out.println("findAllByStatus="+findAllByStatus);
		return inventoryCategoryGroupMapper.mapToDTO(findAllByStatus);
	}

	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroup(String typeId) {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.findAllByTypeId(typeId));
	}

	@Override
	public boolean deleteCategoryGroup(Long id) {
		EOGlobalCategoryGroup eoGlobalCategoryGroup = globalCategoryGroupRepository.getOne(id);
		eoGlobalCategoryGroup.setRecordState(DataStatus.DACTIVETED.getStatus());
		globalCategoryGroupRepository.save(eoGlobalCategoryGroup);
		return true;
	}

}
