package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.dto.UICustCurrencyGroup;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustCurrencyGroup;
import com.brijframework.production.cust.mapper.CustCurrencyGroupMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustCurrencyGroupRepository;
import com.brijframework.production.cust.service.CustCurrencyGroupService;

@Service
public class CustCurrencyGroupServiceImpl implements CustCurrencyGroupService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustCurrencyGroupRepository custCurrencyGroupRepository;
	
	@Autowired
	private CustCurrencyGroupMapper custCurrencyGroupMapper;

	@Override
	public UICustCurrencyGroup saveCurrencyGroup(long custAppId, UICustCurrencyGroup custCurrencyGroup) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		return saveCurrencyGroup(custCurrencyGroup, eoCustBusinessApp);
	}

	private UICustCurrencyGroup saveCurrencyGroup(UICustCurrencyGroup custCurrencyGroup,
			EOCustBusinessApp eoCustBusinessApp) {
		EOCustCurrencyGroup eoCustCurrencyGroup = custCurrencyGroupMapper.mapToDAO(custCurrencyGroup);
		eoCustCurrencyGroup.setCustBusinessApp(eoCustBusinessApp);
		eoCustCurrencyGroup = custCurrencyGroupRepository.saveAndFlush(eoCustCurrencyGroup);
		return custCurrencyGroupMapper.mapToDTO(eoCustCurrencyGroup);
	}

	@Override
	public List<UICustCurrencyGroup> getCurrencyGroupList(long custAppId) {
		return custCurrencyGroupMapper.mapToDTO(custCurrencyGroupRepository.findAllByCustAppId(custAppId));
	}

	@Override
	public UICustCurrencyGroup getCurrencyGroup(long custAppId, Long id) {
		return custCurrencyGroupMapper.mapToDTO(custCurrencyGroupRepository.findOneByIdAndCustAppId(custAppId,id));
	}

	@Override
	public boolean deleteCurrencyGroup(long custAppId, Long id) {
		EOCustCurrencyGroup eoCustCurrencyGroup = custCurrencyGroupRepository.findOneByIdAndCustAppId(custAppId,id);
		if(eoCustCurrencyGroup!=null) {
			eoCustCurrencyGroup.setRecordState(RecordStatus.DACTIVETED.getStatus());
			custCurrencyGroupRepository.save(eoCustCurrencyGroup);
			return true;
		}
		return false;
	}

	@Override
	public List<UICustCurrencyGroup> getCurrencyGroupListByStatus(long custAppId, RecordStatus dataStatus) {
		return custCurrencyGroupMapper.mapToDTO(custCurrencyGroupRepository.findAllByCustAppIdAndStatusIn(custAppId,dataStatus.getStatusIds()));
	}

	@Override
	public List<UICustCurrencyGroup> getCurrencyGroupListByType(long custAppId, String typeId) {
		return custCurrencyGroupMapper.mapToDTO(custCurrencyGroupRepository.findOneByCustAppIdAndTypeId(custAppId,typeId));
	}

}
