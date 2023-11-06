package com.brijframework.production.cust.dto;

import com.brijframework.production.contants.StockStatus;

public class UICustProductStock {

	private Long id;
	private String idenNo;
	private String title;
	private String name;
	private String description;
	private String logoUrl;

	private StockStatus stockStatus;

	private UICustProductStockPrice purchasePrice;
	
	private UICustProductStockPrice salePrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

	public UICustProductStockPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(UICustProductStockPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public UICustProductStockPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(UICustProductStockPrice salePrice) {
		this.salePrice = salePrice;
	}
}
