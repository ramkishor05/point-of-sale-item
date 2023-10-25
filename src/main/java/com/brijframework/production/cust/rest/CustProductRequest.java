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
	private Double purchasePrice;
	private Long purchaseUnitId;

	// for sale items
	private Double retailPrice;
	private Long retailUnitId;
	private Double wholePrice;
	private Long wholeUnitId;

	private Long stockQnt;
	private Long saleQnt;

	private Long custImgId;
	private Long custProductionAppId;
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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(Double wholePrice) {
		this.wholePrice = wholePrice;
	}

	public Long getStockQnt() {
		return stockQnt;
	}

	public void setStockQnt(Long stockQnt) {
		this.stockQnt = stockQnt;
	}

	public Long getSaleQnt() {
		return saleQnt;
	}

	public void setSaleQnt(Long saleQnt) {
		this.saleQnt = saleQnt;
	}

	public Long getCustImgId() {
		return custImgId;
	}

	public void setCustImgId(Long custImgId) {
		this.custImgId = custImgId;
	}

	public Long getCustProductionAppId() {
		return custProductionAppId;
	}

	public void setCustProductionAppId(Long custProductionAppId) {
		this.custProductionAppId = custProductionAppId;
	}

	public Long getCustCategoryId() {
		return custCategoryId;
	}

	public void setCustCategoryId(Long custCategoryId) {
		this.custCategoryId = custCategoryId;
	}

	public Long getPurchaseUnitId() {
		return purchaseUnitId;
	}

	public void setPurchaseUnitId(Long purchaseUnitId) {
		this.purchaseUnitId = purchaseUnitId;
	}

	public Long getRetailUnitId() {
		return retailUnitId;
	}

	public void setRetailUnitId(Long retailUnitId) {
		this.retailUnitId = retailUnitId;
	}

	public Long getWholeUnitId() {
		return wholeUnitId;
	}

	public void setWholeUnitId(Long wholeUnitId) {
		this.wholeUnitId = wholeUnitId;
	}

}
