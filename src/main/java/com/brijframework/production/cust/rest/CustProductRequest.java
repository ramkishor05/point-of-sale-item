package com.brijframework.production.cust.rest;

import java.io.Serializable;
import java.util.Date;

public class CustProductRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	private String title;
	private String name;
	private String description;
	private String logoUrl;
	private Date expDate;
	private Date mfrDate;
	// for purchase items
	private CustProductPriceRequest purchasePrice;
	// for sale items
	private CustProductPriceRequest retailPrice;

	private CustProductPriceRequest wholePrice;

	private Long custBusinessAppId;
	private Long custCategoryId;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getMfrDate() {
		return mfrDate;
	}

	public void setMfrDate(Date mfrDate) {
		this.mfrDate = mfrDate;
	}

	public CustProductPriceRequest getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(CustProductPriceRequest purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public CustProductPriceRequest getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(CustProductPriceRequest retailPrice) {
		this.retailPrice = retailPrice;
	}

	public CustProductPriceRequest getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(CustProductPriceRequest wholePrice) {
		this.wholePrice = wholePrice;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public Long getCustCategoryId() {
		return custCategoryId;
	}

	public void setCustCategoryId(Long custCategoryId) {
		this.custCategoryId = custCategoryId;
	}

}
