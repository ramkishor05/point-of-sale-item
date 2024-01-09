package com.brijframework.production.cust.rest.sale;

import com.brijframework.production.cust.dto.UICustTransaction;
import com.brijframework.production.dto.UIComman;

public class CustProductSalePayment extends UIComman {

	private UICustTransaction custTransaction;
	
	private Long customerId;
	
	private Boolean primaryPayment;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public UICustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(UICustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}
	
}
