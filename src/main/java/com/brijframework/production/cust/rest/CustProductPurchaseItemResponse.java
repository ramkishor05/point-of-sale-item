package com.brijframework.production.cust.rest;

import com.brijframework.production.cust.dto.UICustProduct;
import com.brijframework.production.cust.dto.UICustProductPrice;

public class CustProductPurchaseItemResponse {

	private Long id;
	private String idenNo;
	private Double purchaseQnt;
	private Double discount;
	private UICustProductPrice purchasePrice;
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

	public Double getPurchaseQnt() {
		return purchaseQnt;
	}

	public void setPurchaseQnt(Double purchaseQnt) {
		this.purchaseQnt = purchaseQnt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public UICustProductPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(UICustProductPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public UICustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(UICustProduct custProduct) {
		this.custProduct = custProduct;
	}

}
