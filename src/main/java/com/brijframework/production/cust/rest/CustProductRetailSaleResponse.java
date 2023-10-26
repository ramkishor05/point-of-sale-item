package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustProduct;
import com.brijframework.production.cust.dto.UICustProductPrice;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustProductRetailSaleResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	// for purchase items
	private UICustProductPrice purchasePrice;

	// for sale items
	private Double retailQnt;
	private UICustProductPrice retailPrice;

	private UICustProduct custProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public UICustProductPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(UICustProductPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getRetailQnt() {
		return retailQnt;
	}

	public void setRetailQnt(Double retailQnt) {
		this.retailQnt = retailQnt;
	}

	public UICustProductPrice getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(UICustProductPrice retailPrice) {
		this.retailPrice = retailPrice;
	}

	public UICustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(UICustProduct custProduct) {
		this.custProduct = custProduct;
	}

}
