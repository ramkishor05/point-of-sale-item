package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.rest.CustProductRequest;
import com.brijframework.production.cust.rest.CustProductResponse;

public interface CustProductService {

	CustProductResponse saveProduct(long custBusinessAppId, CustProductRequest Product);

	CustProductResponse saveProduct(CustProductRequest Product);

	CustProductResponse saveProduct(EOCustBusinessApp custBusinessApp, CustProductRequest Product);

	CustProductResponse getProduct(long id);

	List<CustProductResponse> getProductList(long custBusinessAppId);

	CustProductResponse getProduct(long custBusinessAppId, String typeId);

	CustProductResponse updateProduct(long custBusinessAppId, CustProductRequest product);

}
