package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_CATEGORY_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT;
import static com.brijframework.production.contants.Constants.EXP_DATE;
import static com.brijframework.production.contants.Constants.GLB_IMG_ID;
import static com.brijframework.production.contants.Constants.GLB_MRF_ID;
import static com.brijframework.production.contants.Constants.IDEN_NO;
import static com.brijframework.production.contants.Constants.MRF_DATE;
import static com.brijframework.production.contants.Constants.PURCHASE_PRICE;
import static com.brijframework.production.contants.Constants.RETAIL_PRICE;
import static com.brijframework.production.contants.Constants.TITLE;
import static com.brijframework.production.contants.Constants.WHOLE_PRICE;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.production.global.entities.EOGlobalManufacturer;
import com.brijframework.production.global.entities.EOGlobalMediaDetail;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT, uniqueConstraints = {
		@UniqueConstraint(columnNames = { CUST_BUSINESS_APP_ID, IDEN_NO }) })
public class EOCustProduct extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = TITLE)
	private String title;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE, nullable = true)
	private EOCustProductPrice purchasePrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = RETAIL_PRICE, nullable = true)
	private EOCustProductPrice retailPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = WHOLE_PRICE, nullable = true)
	private EOCustProductPrice wholePrice;

	@Column(name = EXP_DATE)
	private Date expDate;

	@Column(name = MRF_DATE)
	private Date mfrDate;

	@OneToOne
	@JoinColumn(name = CUST_CATEGORY_ID)
	public EOCustCategoryItem custCategory;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = GLB_IMG_ID)
	public EOGlobalMediaDetail custImageDetail;

	@OneToOne
	@JoinColumn(name = GLB_MRF_ID)
	public EOGlobalManufacturer custManufacturer;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_PRODUCT, cascade = CascadeType.ALL)
	public List<EOCustProductDetail> custProductDetailList;

	@OneToMany(mappedBy = CUST_PRODUCT, cascade = CascadeType.ALL)
	public List<EOCustProductVariant> custProductVariantList;
	
	@OneToMany(mappedBy = CUST_PRODUCT, cascade = CascadeType.ALL)
	private List<EOCustProductStock> custProductStockList;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EOCustProductPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustProductPrice getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(EOCustProductPrice retailPrice) {
		this.retailPrice = retailPrice;
	}

	public EOCustProductPrice getWholePrice() {
		return wholePrice;
	}

	public void setWholePrice(EOCustProductPrice wholePrice) {
		this.wholePrice = wholePrice;
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

	public EOCustCategoryItem getCustCategory() {
		return custCategory;
	}

	public void setCustCategory(EOCustCategoryItem custCategory) {
		this.custCategory = custCategory;
	}

	public EOGlobalMediaDetail getCustImageDetail() {
		return custImageDetail;
	}

	public void setCustImageDetail(EOGlobalMediaDetail custImageDetail) {
		this.custImageDetail = custImageDetail;
	}

	public EOGlobalManufacturer getCustManufacturer() {
		return custManufacturer;
	}

	public void setCustManufacturer(EOGlobalManufacturer custManufacturer) {
		this.custManufacturer = custManufacturer;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustProductDetail> getCustProductDetailList() {
		return custProductDetailList;
	}

	public void setCustProductDetailList(List<EOCustProductDetail> custProductDetailList) {
		this.custProductDetailList = custProductDetailList;
	}

	public List<EOCustProductVariant> getCustProductVariantList() {
		return custProductVariantList;
	}

	public void setCustProductVariantList(List<EOCustProductVariant> custProductVariantList) {
		this.custProductVariantList = custProductVariantList;
	}

	public List<EOCustProductStock> getCustProductStockList() {
		return custProductStockList;
	}

	public void setCustProductStockList(List<EOCustProductStock> custProductStockList) {
		this.custProductStockList = custProductStockList;
	}
	
	public String finalName() {
		if(this.getName()!=null) {
			return this.getName();
		}
		if(this.getDescription()!=null) {
			return this.getDescription();
		}
		if(this.getTitle()!=null) {
			return this.getTitle();
		}
		return "";
	}
}
