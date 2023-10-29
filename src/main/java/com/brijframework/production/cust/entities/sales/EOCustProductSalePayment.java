package com.brijframework.production.cust.entities.sales;

import static com.brijframework.production.contants.Constants.CUSTOMER_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_SALE_PAYMENT;

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
@Table(name = EOCUST_PRODUCT_SALE_PAYMENT)
public class EOCustProductSalePayment extends EOCustObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MODE")
	@Enumerated(EnumType.STRING)
	private PaymentMode mode;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	@ManyToOne
	private EOCustProductSale custProductSale;

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

	public EOCustProductSale getCustProductSale() {
		return custProductSale;
	}

	public void setCustProductSale(EOCustProductSale custProductSale) {
		this.custProductSale = custProductSale;
	}
	
}
