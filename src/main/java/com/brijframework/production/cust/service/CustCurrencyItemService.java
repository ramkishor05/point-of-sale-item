package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.rest.CustCurrencyItemRequest;
import com.brijframework.production.cust.rest.CustCurrencyItemResponse;

public interface CustCurrencyItemService {

	CustCurrencyItemResponse saveCurrencyItem(long custAppId, CustCurrencyItemRequest custCurrencyItemRequest);

	CustCurrencyItemResponse saveCurrencyItem(EOCustBusinessApp eoCustBusinessApp, CustCurrencyItemRequest uiCustCurrencyItem);

	CustCurrencyItemResponse getCurrencyItem(long custAppId, long id);

	List<CustCurrencyItemResponse> getCurrencyItemList(long custAppId);

	boolean deleteCurrencyItem(long custAppId, Long id);

	List<CustCurrencyItemResponse> findAllByType(long custAppId, String typeId);

}
