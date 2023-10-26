package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.rest.CustCategoryRequest;
import com.brijframework.production.cust.rest.CustCategoryResponse;

public interface CustCategoryService {

	CustCategoryResponse saveCategory(long custAppId, CustCategoryRequest custCategoryRequest);

	CustCategoryResponse saveCategory(EOCustBusinessApp eoCustBusinessApp, CustCategoryRequest uiCustCategory);

	CustCategoryResponse getCategory(long custAppId, long id);

	List<CustCategoryResponse> getCategoryList(long custAppId);

	boolean deleteCategory(long custAppId, Long id);

	List<CustCategoryResponse> findAllByType(long custAppId, String typeId);

}
