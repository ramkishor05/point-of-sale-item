package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.dto.UICustBusinessApp;
import com.brijframework.production.cust.dto.UICustBusinessAppDetail;

public interface CustBusinessAppService {

	UICustBusinessApp saveCustBusinessApp(UICustBusinessApp inventory);

	UICustBusinessApp getCustBusinessApp(long id);

	boolean deleteCustBusinessApp(long id);

	List<UICustBusinessApp> getCustBusinessAppList();

	UICustBusinessAppDetail getCustBusinessAppDetail(long id);
}
