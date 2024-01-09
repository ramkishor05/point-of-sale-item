package com.brijframework.production.cust.entities.sales;

import static com.brijframework.production.contants.Constants.CUSTOMER_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.production.contants.Constants.CUST_TRANSACTION_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_SALE_PAYMENT;
import static com.brijframework.production.contants.Constants.PRIMARY_PAYMENT;

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
@Table(name = EOCUST_PRODUCT_SALE_PAYMENT)
public class EOCustProductSalePayment extends EOCustObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@Column(name = PRIMARY_PAYMENT, nullable = false)
	private Boolean primaryPayment;
	
	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	@ManyToOne
	private EOCustProductSale custProductSale;
	
	@JoinColumn(name = CUST_TRANSACTION_ID)
	@OneToOne(cascade = CascadeType.ALL)
	private EOCustTransaction custTransaction;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public EOCustProductSale getCustProductSale() {
		return custProductSale;
	}

	public void setCustProductSale(EOCustProductSale custProductSale) {
		this.custProductSale = custProductSale;
	}

	public EOCustTransaction getCustTransaction() {
		return custTransaction;
	}

	public void setCustTransaction(EOCustTransaction custTransaction) {
		this.custTransaction = custTransaction;
	}
	
}
