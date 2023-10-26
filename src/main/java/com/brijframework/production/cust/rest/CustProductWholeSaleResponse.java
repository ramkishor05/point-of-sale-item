package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustProduct;
import com.brijframework.production.cust.dto.UICustProductPrice;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class CustProductWholeSaleResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	// for purchase items
	private UICustProductPrice purchasePrice;
	private Double purchaseQnt;

	// for sale items
	private Double wholeQnt;
	private UICustProductPrice wholePrice;

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

	public Double getPurchaseQnt() {
		return purchaseQnt;
	}

	public void setPurchaseQnt(Double purchaseQnt) {
		this.purchaseQnt = purchaseQnt;
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

	public UICustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(UICustProduct custProduct) {
		this.custProduct = custProduct;
	}

}
