package com.brijframework.production.cust.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.brijframework.production.dto.UIManufacturer;
import com.brijframework.production.dto.UIProductDetail;
import com.brijframework.production.dto.UIProductRecipe;
import com.brijframework.production.dto.UIProductVariant;

public class UICustProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String idenNo;
	private String title;
	private String name;
	private String description;
	private String logoUrl;

	private Long glbImgDetailId;

	private Long custBusinessAppId;
	private Long categoryId;

	private Date expDate;
	private Date mfrDate;

	// for purchase items
	private UICustProductPrice purchasePrice;

	// for sale items
	private UICustProductPrice retailPrice;
	private UICustProductPrice wholePrice;

	private Long stockQnt;

	private Long saleQnt;

	public UIManufacturer manufacturer;

	public List<UIProductRecipe> productRecipes;

	public List<UIProductDetail> productDetails;

	public List<UIProductVariant> productVariants;

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

	public Long getGlbImgDetailId() {
		return glbImgDetailId;
	}

	public void setGlbImgDetailId(Long glbImgDetailId) {
		this.glbImgDetailId = glbImgDetailId;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public UICustProductPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(UICustProductPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public UICustProductPrice getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(UICustProductPrice retailPrice) {
		this.retailPrice = retailPrice;
	}

	public UICustProductPrice getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(UICustProductPrice wholePrice) {
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

	public UIManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(UIManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<UIProductRecipe> getProductRecipes() {
		return productRecipes;
	}

	public void setProductRecipes(List<UIProductRecipe> productRecipes) {
		this.productRecipes = productRecipes;
	}

	public List<UIProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<UIProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public List<UIProductVariant> getProductVariants() {
		return productVariants;
	}

	public void setProductVariants(List<UIProductVariant> productVariants) {
		this.productVariants = productVariants;
	}

}
