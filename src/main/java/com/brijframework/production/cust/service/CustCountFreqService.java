package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.rest.CustCountFreqRequest;
import com.brijframework.production.cust.rest.CustCountFreqResponse;

public interface CustCountFreqService {

	CustCountFreqResponse saveCountFreq(long custAppId, CustCountFreqRequest custCountFreqRequest);

	List<CustCountFreqResponse> getCountFreqList(long custAppId);

	List<CustCountFreqResponse> getCountFreq(long custAppId, String typeId);

	CustCountFreqResponse getCountFreq(Long id);

	boolean deleteCountFreq(Long id);

}
