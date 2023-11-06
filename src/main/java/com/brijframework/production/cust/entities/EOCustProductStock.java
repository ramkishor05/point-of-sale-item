package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_STOCK;
import static com.brijframework.production.contants.Constants.IDEN_NO;
import static com.brijframework.production.contants.Constants.PURCHASE_PRICE;
import static com.brijframework.production.contants.Constants.SALE_PRICE;
import static com.brijframework.production.contants.Constants.STOCK_STATUS;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.production.contants.StockStatus;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_STOCK, uniqueConstraints = {
		@UniqueConstraint (columnNames = { 
				CUST_BUSINESS_APP_ID,CUST_PRODUCT_ID, IDEN_NO })})
public class EOCustProductStock extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = STOCK_STATUS)
	@Enumerated(EnumType.STRING)
	private StockStatus stockStatus; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustProductStockPrice purchasePrice;

	// for sale cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = SALE_PRICE)
	private EOCustProductStockPrice salePrice;
	
	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_ID)
	private EOCustProduct custProduct;
	
	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	private EOCustProductPurchaseItem custProductPurchaseItem;
	
	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	private EOCustProductSaleItem custProductSaleItem;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

	public EOCustProductStockPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductStockPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustProductStockPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(EOCustProductStockPrice salePrice) {
		this.salePrice = salePrice;
	}

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}

	public EOCustProductPurchaseItem getCustProductPurchaseItem() {
		return custProductPurchaseItem;
	}

	public void setCustProductPurchaseItem(EOCustProductPurchaseItem custProductPurchaseItem) {
		this.custProductPurchaseItem = custProductPurchaseItem;
	}

	public EOCustProductSaleItem getCustProductSaleItem() {
		return custProductSaleItem;
	}

	public void setCustProductSaleItem(EOCustProductSaleItem custProductSaleItem) {
		this.custProductSaleItem = custProductSaleItem;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}
}
