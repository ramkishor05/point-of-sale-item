package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustProductPrice;

public class CustProductWholeSaleRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	// for purchase items
	private UICustProductPrice purchasePrice;
	private Long custProductId;
	// for sale items
	private Double wholeQnt;
	private UICustProductPrice wholePrice;

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

	public Double getWholeQnt() {
		return wholeQnt;
	}

	public void setWholeQnt(Double wholeQnt) {
		this.wholeQnt = wholeQnt;
	}

	public UICustProductPrice getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(UICustProductPrice wholePrice) {
		this.wholePrice = wholePrice;
	}

}
