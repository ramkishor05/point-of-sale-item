package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustAccount;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.mapper.CustAccountRequestMapper;
import com.brijframework.production.cust.mapper.CustAccountResponseMapper;
import com.brijframework.production.cust.repository.CustAccountRepository;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.rest.CustAccountRequest;
import com.brijframework.production.cust.rest.CustAccountResponse;
import com.brijframework.production.cust.service.CustAccountService;

@Service
public class CustAccountServiceImpl implements CustAccountService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustAccountRepository custAccountRepository;
	
	@Autowired
	private CustAccountRequestMapper custAccountRequestMapper;
	
	@Autowired
	private CustAccountResponseMapper custAccountResponseMapper;

	@Override
	public CustAccountResponse saveAccount(Long custAppId, CustAccountRequest custAccountRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustAccount eoCustAccount = custAccountRequestMapper.mapToDAO(custAccountRequest);
		eoCustAccount.setCustBusinessApp(eoCustBusinessApp);
		eoCustAccount=custAccountRepository.save(eoCustAccount);
		return custAccountResponseMapper.mapToDTO(eoCustAccount);
	}

	@Override
	public List<CustAccountResponse> getAccountList(Long custAppId) {
		return custAccountResponseMapper.mapToDTO(custAccountRepository.findAllByCustAppAndUserId(custAppId).orElse(null));
	}

	@Override
	public List<CustAccountResponse> getAccountFiltedList(Long custAppId, String startDate, String endDate) {
		return custAccountResponseMapper.mapToDTO(custAccountRepository.findAllByCustAppAndUserId(custAppId, startDate, endDate).orElse(null));
	}

	@Override
	public CustAccountResponse getAccount(Long custAppId, Long id) {
		return null;
	}

	@Override
	public boolean deleteAccount(Long custAppId, Long id) {
		return false;
	}

}
