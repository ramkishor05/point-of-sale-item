package com.brijframework.production.cust.service;

import java.time.LocalDateTime;
import java.util.List;

import com.brijframework.production.cust.rest.sale.CustProductSaleRequest;
import com.brijframework.production.cust.rest.sale.CustProductSaleResponse;

public interface CustProductSaleService {

	CustProductSaleResponse saveProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest);

	CustProductSaleResponse updateProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest);

	List<CustProductSaleResponse> getProductSaleList(long custAppId);

	CustProductSaleResponse getProductSale(long custAppId, String typeId);

	List<CustProductSaleResponse> filterProductSaleList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	boolean deleteProductSale(long custAppId, Long id);

	List<CustProductSaleResponse> getProductSaleListBySupplier(long custAppId, Long customerId);

	List<CustProductSaleResponse> getProductSaleListByUser(long custAppId, Long userId);

}
