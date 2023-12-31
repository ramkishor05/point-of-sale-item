package com.brijframework.production.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.global.entities.EOGlobalCountFreq;
import com.brijframework.production.global.mapper.GlobalCountFreqMapper;
import com.brijframework.production.global.mapper.GlobalCountFreqRequestMapper;
import com.brijframework.production.global.mapper.GlobalCountFreqResponseMapper;
import com.brijframework.production.global.repository.GlobalCountFreqRepository;
import com.brijframework.production.global.rest.GlobalCountFreqRequest;
import com.brijframework.production.global.rest.GlobalCountFreqResponse;
import com.brijframework.production.global.service.GlobalCountFreqService;

@Service
public class GlobalCountFreqServiceImpl implements GlobalCountFreqService {
	
	@Autowired
	CustBusinessAppRepository custProductionAppRepository;
	
	@Autowired
	GlobalCountFreqRepository countFreqRepository;
	
	@Autowired
	GlobalCountFreqMapper globalCountFreqMapper;
	
	@Autowired
	GlobalCountFreqRequestMapper globalCountFreqRequestMapper;
	
	@Autowired
	GlobalCountFreqResponseMapper globalCountFreqResponseMapper;
	
	@Override
	public GlobalCountFreqResponse saveCountFreq(GlobalCountFreqRequest globalCountFreqRequest) {
		EOGlobalCountFreq eoCountFreq=globalCountFreqRequestMapper.mapToDAO(globalCountFreqRequest);
		countFreqRepository.save(eoCountFreq);
		return globalCountFreqResponseMapper.mapToDTO(eoCountFreq);
	}

	@Override
	public GlobalCountFreqResponse getCountFreq(long id) {
		return globalCountFreqResponseMapper.mapToDTO(countFreqRepository.getOne(id));
	}

	@Override
	public List<GlobalCountFreqResponse> getCountFreqList() {
		return globalCountFreqResponseMapper.mapToDTO(countFreqRepository.findAll());
	}

	@Override
	public boolean deleteCountFreq(Long id) {
		countFreqRepository.deleteById(id);
		return true;
	}

}
