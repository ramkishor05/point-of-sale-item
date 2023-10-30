package com.brijframework.production.cust.rest.sale;

import com.brijframework.production.contants.PaymentMode;
import com.brijframework.production.dto.UIComman;

public class CustProductSalePayment extends UIComman {

	private PaymentMode mode;
	
	private Double amount;
	
	private Long customerId;

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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
