package com.brijframework.production.cust.rest;

public class CustProductPriceRequest {
	private Double price;
	private Long currencyId;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	
}
