package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.COLOR;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_VARIANT;
import static com.brijframework.production.contants.Constants.IDEN_NO;
import static com.brijframework.production.contants.Constants.RETAIL_PRICE;
import static com.brijframework.production.contants.Constants.SIZE;
import static com.brijframework.production.contants.Constants.TITLE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_VARIANT, uniqueConstraints = {
		@UniqueConstraint (columnNames = { 
				CUST_BUSINESS_APP_ID,CUST_PRODUCT_ID, IDEN_NO })})
public class EOCustProductVariant extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = TITLE)
	private String title;
	
	@Column(name = RETAIL_PRICE)
	private Double retailPrice;
	
	@Column(name = COLOR)
	private String color;
	
	@Column(name = SIZE)
	private Double size;

	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_ID)
	public EOCustProduct custProduct;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}
}
