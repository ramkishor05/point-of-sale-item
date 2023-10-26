package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_COUNT_FREQ_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_COUNT_FREQ;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name=EOCUST_PRODUCT_COUNT_FREQ, uniqueConstraints = { @UniqueConstraint(columnNames = { 
		CUST_BUSINESS_APP_ID, CUST_PRODUCT_ID, CUST_COUNT_FREQ_ID }) })
public class EOCustProductCountFreq extends EOCustObject{


	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name=CUST_PRODUCT_ID)
	public EOCustProduct  custProduct;
	
	@OneToOne
	@JoinColumn(name=CUST_COUNT_FREQ_ID)
	public EOCustCountFreq custCountFreq;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}

	public EOCustCountFreq getCustCountFreq() {
		return custCountFreq;
	}

	public void setCustCountFreq(EOCustCountFreq custCountFreq) {
		this.custCountFreq = custCountFreq;
	}
	
	
}
