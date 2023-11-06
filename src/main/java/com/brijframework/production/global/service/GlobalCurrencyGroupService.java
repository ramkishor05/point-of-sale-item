package com.brijframework.production.global.service;

import java.util.List;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;

public interface GlobalCurrencyGroupService {

	UIGlobalCurrencyGroup saveCurrencyGroup(UIGlobalCurrencyGroup unitGroup);

	UIGlobalCurrencyGroup getCurrencyGroup(long id);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList();

	List<UIGlobalCurrencyGroup> getCurrencyGroup( String typeId);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList(RecordStatus dataStatus);

	boolean deleteCurrencyGroup(Long id);

}
