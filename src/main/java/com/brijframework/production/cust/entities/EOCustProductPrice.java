package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PRICE;
import static com.brijframework.production.contants.Constants.PRICE;
import static com.brijframework.production.contants.Constants.CURRENCY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PRICE)
public class EOCustProductPrice extends EOCustObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EOCustProductPrice() {
		// TODO Auto-generated constructor stub
	}
	
	// for purchase cost
	@Column(name = PRICE)
	private Double price;
	
	@JoinColumn(name = CURRENCY)
	@OneToOne
	private EOCustCurrencyItem currency;

	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_ID)
	public EOCustProduct custProduct;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public EOCustCurrencyItem getCurrency() {
		return currency;
	}

	public void setCurrency(EOCustCurrencyItem currency) {
		this.currency = currency;
	}

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}
}
