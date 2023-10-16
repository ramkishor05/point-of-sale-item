package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.DataStatus;
import com.brijframework.production.cust.dto.UICustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustProductionApp;
import com.brijframework.production.cust.mapper.CustCategoryGroupMapper;
import com.brijframework.production.cust.repository.CustCategoryGroupRepository;
import com.brijframework.production.cust.repository.CustProductionAppRepository;
import com.brijframework.production.cust.service.CustCategoryGroupService;

@Service
public class CustCategoryGroupServiceImpl implements CustCategoryGroupService {
	
	@Autowired
	private CustProductionAppRepository custProductionAppRepository;
	
	@Autowired
	private CustCategoryGroupRepository custCategoryGroupRepository;
	
	@Autowired
	private CustCategoryGroupMapper custCategoryGroupMapper;

	@Override
	public UICustCategoryGroup saveCategoryGroup(long custAppId, UICustCategoryGroup custCategoryGroup) {
		Optional<EOCustProductionApp> findById = custProductionAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustProductionApp eoCustProductionApp = findById.get();
		return saveCategoryGroup(custCategoryGroup, eoCustProductionApp);
	}

	private UICustCategoryGroup saveCategoryGroup(UICustCategoryGroup custCategoryGroup,
			EOCustProductionApp eoCustProductionApp) {
		EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupMapper.mapToDAO(custCategoryGroup);
		eoCustCategoryGroup.setCustProductionApp(eoCustProductionApp);
		eoCustCategoryGroup = custCategoryGroupRepository.saveAndFlush(eoCustCategoryGroup);
		return custCategoryGroupMapper.mapToDTO(eoCustCategoryGroup);
	}

	@Override
	public List<UICustCategoryGroup> getCategoryGroupList(long custAppId) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findAllByCustAppId(custAppId));
	}

	@Override
	public UICustCategoryGroup getCategoryGroup(long custAppId, Long id) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findOneByIdAndCustAppId(custAppId,id));
	}

	@Override
	public boolean deleteCategoryGroup(long custAppId, Long id) {
		EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupRepository.findOneByIdAndCustAppId(custAppId,id);
		if(eoCustCategoryGroup!=null) {
			eoCustCategoryGroup.setRecordState(DataStatus.DACTIVETED.getStatus());
			custCategoryGroupRepository.save(eoCustCategoryGroup);
			return true;
		}
		return false;
	}

	@Override
	public List<UICustCategoryGroup> getCategoryGroupListByStatus(long custAppId, DataStatus dataStatus) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findAllByCustAppIdAndStatusIn(custAppId,dataStatus.getStatusIds()));
	}

	@Override
	public List<UICustCategoryGroup> getCategoryGroupListByType(long custAppId, String typeId) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findOneByCustAppIdAndTypeId(custAppId,typeId));
	}

}
