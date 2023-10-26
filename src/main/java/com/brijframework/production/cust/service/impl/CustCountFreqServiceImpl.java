package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustCountFreq;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.mapper.CustCountFreqRequestMapper;
import com.brijframework.production.cust.mapper.CustCountFreqResponseMapper;
import com.brijframework.production.cust.repository.CustCountFreqRepository;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.rest.CustCountFreqRequest;
import com.brijframework.production.cust.rest.CustCountFreqResponse;
import com.brijframework.production.cust.service.CustCountFreqService;

@Service
public class CustCountFreqServiceImpl implements CustCountFreqService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustCountFreqRepository custCountFreqRepository;
	
	@Autowired
	private CustCountFreqRequestMapper custCountFreqRequestMapper;
	
	@Autowired
	private CustCountFreqResponseMapper custCountFreqResponseMapper;

	@Override
	public CustCountFreqResponse saveCountFreq(long custAppId, CustCountFreqRequest custCountFreqRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustCountFreq saveCountFreq = saveCountFreq(custCountFreqRequest, eoCustBusinessApp);
		return custCountFreqResponseMapper.mapToDTO(saveCountFreq);
	}

	private EOCustCountFreq saveCountFreq(CustCountFreqRequest custCountFreqRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		EOCustCountFreq eoCustCountFreq = custCountFreqRequestMapper.mapToDAO(custCountFreqRequest);
		eoCustCountFreq.setCustBusinessApp(eoCustBusinessApp);
		eoCustCountFreq = custCountFreqRepository.save(eoCustCountFreq);
		return eoCustCountFreq;
	}

	@Override
	public List<CustCountFreqResponse> getCountFreqList(long custAppId) {
		return custCountFreqResponseMapper.mapToDTO(custCountFreqRepository.findAllByCustAppId(custAppId));
	}

	@Override
	public List<CustCountFreqResponse> getCountFreq(long custAppId, String typeId) {
		return custCountFreqResponseMapper.mapToDTO(custCountFreqRepository.findAllByCustAppIdAndTypeId(custAppId, typeId));
	}

}
