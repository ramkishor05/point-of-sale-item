package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustProduct;
import com.brijframework.production.cust.dto.UICustProductPrice;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustProductSaleItemResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	private UICustProductPrice purchasePrice;
	private UICustProductPrice salePrice;
	private Double saleQnt;
	private Double discount;
	private String saleType;
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

	public UICustProductPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(UICustProductPrice salePrice) {
		this.salePrice = salePrice;
	}

	public Double getSaleQnt() {
		return saleQnt;
	}

	public void setSaleQnt(Double saleQnt) {
		this.saleQnt = saleQnt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public UICustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(UICustProduct custProduct) {
		this.custProduct = custProduct;
	}

}
