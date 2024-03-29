package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.repository.CustProductStockRepository.ProductStock;

public interface CustProductStockService {

	List<ProductStock> getProductStockList(long custAppId, Long productId);
	
	boolean deleteProductStock(long custAppId, long id);
	/*
	void saveCustProductStocks(EOCustProductPurchaseItem custProductRetailPurchase);

	void saveCustProductStocks(EOCustProductSaleItem custProductRetailSale);

	void saveCustProductStocksBackground(EOCustProductSaleItem eoCustProductSaleItem);

	void saveCustProductStocksBackground(EOCustProductPurchaseItem eoCustProductSaleItem);
*/
}
