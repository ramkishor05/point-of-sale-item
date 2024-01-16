package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.rest.CustTransationRequest;
import com.brijframework.production.cust.rest.CustTransationResponse;

public interface CustTransationService {

	CustTransationResponse saveTransation(Long custAppId, CustTransationRequest custCashBookRequest);

	List<CustTransationResponse> getTransationList(Long custAppId, Long userId);

	CustTransationResponse getTransation(Long custAppId, Long id);

	boolean deleteTransation(Long custAppId, Long id);

	List<CustTransationResponse> getTransationFiltedList(Long custAppId, Long userId, String startDate, String endDate);

}
