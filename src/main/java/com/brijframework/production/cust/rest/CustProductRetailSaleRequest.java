package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustProductPrice;

public class CustProductRetailSaleRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	// for purchase items
	private UICustProductPrice purchasePrice;

	private Long custProductId;
	// for sale items
	private Double retailQnt;
	private UICustProductPrice retailPrice;

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

	public Long getCustProductId() {
		return custProductId;
	}

	public void setCustProductId(Long custProductId) {
		this.custProductId = custProductId;
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

}
