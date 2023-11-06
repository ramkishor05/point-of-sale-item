package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.dto.UICustCurrencyGroup;

public interface CustCurrencyGroupService {

	UICustCurrencyGroup saveCurrencyGroup(long custAppId, UICustCurrencyGroup custCurrencyGroup);

	List<UICustCurrencyGroup> getCurrencyGroupList(long custAppId);

	UICustCurrencyGroup getCurrencyGroup(long custAppId, Long id);

	boolean deleteCurrencyGroup(long custAppId, Long id);

	List<UICustCurrencyGroup> getCurrencyGroupListByStatus(long custAppId, RecordStatus dataStatus);

	List<UICustCurrencyGroup> getCurrencyGroupListByType(long custAppId, String typeId);

}
