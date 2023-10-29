package com.brijframework.production.cust.entities.purchases;

import static com.brijframework.production.contants.Constants.SUPPLIER_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PURCHASE_PAYMENT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.brijframework.production.contants.PaymentMode;
import com.brijframework.production.cust.entities.EOCustObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_PAYMENT)
public class EOCustProductPurchasePayment extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MODE")
	@Enumerated(EnumType.STRING)
	private PaymentMode mode;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustProductPurchase custProductPurchase;

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

	public EOCustProductPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustProductPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

}
