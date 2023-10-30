package com.brijframework.production.cust.service;

import java.time.LocalDateTime;
import java.util.List;

import com.brijframework.production.cust.rest.purchase.CustProductPurchaseRequest;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseResponse;

public interface CustProductPurchaseService {

	CustProductPurchaseResponse saveProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest);

	CustProductPurchaseResponse updateProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest);

	List<CustProductPurchaseResponse> getProductPurchaseList(long custAppId);

	CustProductPurchaseResponse getProductPurchase(long custAppId, String typeId);

	List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	boolean deleteProductPurchase(long custAppId, Long id);

}
