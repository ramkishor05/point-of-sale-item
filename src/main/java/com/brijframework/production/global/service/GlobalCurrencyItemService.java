package com.brijframework.production.global.service;

import java.util.List;

import com.brijframework.production.global.rest.GlobalCurrencyItemRequest;
import com.brijframework.production.global.rest.GlobalCurrencyItemResponse;

public interface GlobalCurrencyItemService {

	GlobalCurrencyItemResponse saveCurrencyItem(GlobalCurrencyItemRequest globalCurrencyItemRequest);

	GlobalCurrencyItemResponse getCurrencyItem(Long id);

	List<GlobalCurrencyItemResponse> getCurrencyItemList();

	List<GlobalCurrencyItemResponse> findAllByType(String typeId);

	boolean deleteCurrencyItem(Long id);

}
