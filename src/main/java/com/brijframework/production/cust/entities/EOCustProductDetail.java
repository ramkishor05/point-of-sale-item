package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.ATTRIBUTE_NAME;
import static com.brijframework.production.contants.Constants.ATTRIBUTE_VALUE;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_DETAIL;
import static com.brijframework.production.contants.Constants.SECTION_NAME;

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
@Table(name=EOCUST_PRODUCT_DETAIL, uniqueConstraints = { @UniqueConstraint(columnNames = { 
		CUST_BUSINESS_APP_ID, CUST_PRODUCT_ID, SECTION_NAME, ATTRIBUTE_NAME }) })
public class EOCustProductDetail extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = SECTION_NAME)
	private String sectionName;
	
	@Column(name = ATTRIBUTE_NAME)
	private String attributeName;
	
	@Column(name = ATTRIBUTE_VALUE)
	private String attributeValue;

	@ManyToOne
	@JoinColumn(name = CUST_PRODUCT_ID)
	public EOCustProduct custProduct;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}
   
}