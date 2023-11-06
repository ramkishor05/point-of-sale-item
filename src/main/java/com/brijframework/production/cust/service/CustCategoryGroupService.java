package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.dto.UICustCategoryGroup;

public interface CustCategoryGroupService {

	UICustCategoryGroup saveCategoryGroup(long custAppId, UICustCategoryGroup custCategoryGroup);

	List<UICustCategoryGroup> getCategoryGroupList(long custAppId);

	UICustCategoryGroup getCategoryGroup(long custAppId, Long id);

	boolean deleteCategoryGroup(long custAppId, Long id);

	List<UICustCategoryGroup> getCategoryGroupListByStatus(long custAppId, RecordStatus dataStatus);

	List<UICustCategoryGroup> getCategoryGroupListByType(long custAppId, String typeId);

}
