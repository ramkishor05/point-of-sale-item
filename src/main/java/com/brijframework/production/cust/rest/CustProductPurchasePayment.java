package com.brijframework.production.cust.rest;

import com.brijframework.production.contants.PaymentMode;

public class CustProductPurchasePayment {
	
	public long id;

	private PaymentMode mode;

	private Double amount;

	private Long supplierId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	
}
