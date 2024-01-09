package com.brijframework.production.cust.entities.purchases;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.production.contants.Constants.CUST_TRANSACTION_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PURCHASE_PAYMENT;
import static com.brijframework.production.contants.Constants.PRIMARY_PAYMENT;
import static com.brijframework.production.contants.Constants.SUPPLIER_ID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.brijframework.production.cust.entities.EOCustObject;
import com.brijframework.production.cust.entities.EOCustTransaction;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_PAYMENT)
public class EOCustProductPurchasePayment extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;
	
	@Column(name = PRIMARY_PAYMENT, nullable = false)
	private Boolean primaryPayment;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustProductPurchase custProductPurchase;

	@JoinColumn(name = CUST_TRANSACTION_ID)
	@OneToOne(cascade = CascadeType.ALL)
	private EOCustTransaction custTransaction;

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

	public EOCustProductPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustProductPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}

	public EOCustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(EOCustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}
}
