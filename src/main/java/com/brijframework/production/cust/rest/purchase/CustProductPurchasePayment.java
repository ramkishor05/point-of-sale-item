package com.brijframework.production.cust.rest.purchase;

import com.brijframework.production.cust.dto.UICustTransaction;
import com.brijframework.production.dto.UIComman;

public class CustProductPurchasePayment extends UIComman {
	
	private Long supplierId;
	
	private Boolean primaryPayment;
	
	private UICustTransaction custTransaction;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public UICustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(UICustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}
	
}
