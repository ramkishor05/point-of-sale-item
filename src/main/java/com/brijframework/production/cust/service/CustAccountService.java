package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.rest.CustAccountRequest;
import com.brijframework.production.cust.rest.CustAccountResponse;

public interface CustAccountService {

	CustAccountResponse saveAccount(Long custAppId, CustAccountRequest custAccountRequest);

	List<CustAccountResponse> getAccountList(Long custAppId);

	List<CustAccountResponse> getAccountFiltedList(Long custAppId, String startDate, String endDate);

	CustAccountResponse getAccount(Long custAppId, Long id);

	boolean deleteAccount(Long custAppId, Long id);

}
