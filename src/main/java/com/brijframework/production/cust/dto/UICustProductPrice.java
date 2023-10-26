package com.brijframework.production.cust.dto;

public class UICustProductPrice {
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
