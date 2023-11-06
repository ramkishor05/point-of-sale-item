package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;
import com.brijframework.production.cust.rest.CustProductStockResponse;

public interface CustProductStockService {

	List<CustProductStockResponse> getProductStockList(long custAppId, Long productId);

	boolean deleteProductStock(long custAppId, long id);

	void saveCustProductStocks(EOCustProductPurchaseItem custProductRetailPurchase);

	void saveCustProductStocks(EOCustProductSaleItem custProductRetailSale);

	void saveCustProductStocksBackground(EOCustProductSaleItem eoCustProductSaleItem);

	void saveCustProductStocksBackground(EOCustProductPurchaseItem eoCustProductSaleItem);

}
