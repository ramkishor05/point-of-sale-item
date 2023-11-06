package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.dto.UICustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.cust.mapper.CustCategoryGroupMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustCategoryGroupRepository;
import com.brijframework.production.cust.service.CustCategoryGroupService;

@Service
public class CustCategoryGroupServiceImpl implements CustCategoryGroupService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustCategoryGroupRepository custCategoryGroupRepository;
	
	@Autowired
	private CustCategoryGroupMapper custCategoryGroupMapper;

	@Override
	public UICustCategoryGroup saveCategoryGroup(long custAppId, UICustCategoryGroup custCategoryGroup) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		return saveCategoryGroup(custCategoryGroup, eoCustBusinessApp);
	}

	private UICustCategoryGroup saveCategoryGroup(UICustCategoryGroup custCategoryGroup,
			EOCustBusinessApp eoCustBusinessApp) {
		EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupMapper.mapToDAO(custCategoryGroup);
		eoCustCategoryGroup.setCustBusinessApp(eoCustBusinessApp);
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
			eoCustCategoryGroup.setRecordState(RecordStatus.DACTIVETED.getStatus());
			custCategoryGroupRepository.save(eoCustCategoryGroup);
			return true;
		}
		return false;
	}

	@Override
	public List<UICustCategoryGroup> getCategoryGroupListByStatus(long custAppId, RecordStatus dataStatus) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findAllByCustAppIdAndStatusIn(custAppId,dataStatus.getStatusIds()));
	}

	@Override
	public List<UICustCategoryGroup> getCategoryGroupListByType(long custAppId, String typeId) {
		return custCategoryGroupMapper.mapToDTO(custCategoryGroupRepository.findOneByCustAppIdAndTypeId(custAppId,typeId));
	}

}
