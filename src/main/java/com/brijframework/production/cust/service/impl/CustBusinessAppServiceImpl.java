package com.brijframework.production.cust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustBusinessApp;
import com.brijframework.production.cust.dto.UICustBusinessAppDetail;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.mapper.CustBusinessAppDetailMapper;
import com.brijframework.production.cust.mapper.CustBusinessAppMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.service.CustBusinessAppService;

@Service
public class CustBusinessAppServiceImpl implements CustBusinessAppService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustBusinessAppMapper  custBusinessAppMapper;
	
	@Autowired
	private CustBusinessAppDetailMapper custBusinessAppDetailMapper;
	
	@Override
	public UICustBusinessApp saveCustBusinessApp(UICustBusinessApp uiCustBusinessApp) {
		EOCustBusinessApp eoCustBusinessApp=custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(uiCustBusinessApp.getCustId(), uiCustBusinessApp.getAppId(),uiCustBusinessApp.getBusinessId()).orElse(new EOCustBusinessApp());
		eoCustBusinessApp.setAppId(uiCustBusinessApp.getAppId());
		eoCustBusinessApp.setCustId(uiCustBusinessApp.getCustId());
		eoCustBusinessApp.setBusinessId(uiCustBusinessApp.getBusinessId());
		custBusinessAppRepository.save(eoCustBusinessApp);
		return custBusinessAppMapper.mapToDTO(eoCustBusinessApp);
	}

	@Override
	public UICustBusinessApp getCustBusinessApp(long id) {
		return custBusinessAppMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteCustBusinessApp(long id) {
		return false;
	}

	@Override
	public List<UICustBusinessApp> getCustBusinessAppList() {
		return null;
	}

	@Override
	public UICustBusinessAppDetail getCustBusinessAppDetail(long id) {
		return custBusinessAppDetailMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );

	}
}
