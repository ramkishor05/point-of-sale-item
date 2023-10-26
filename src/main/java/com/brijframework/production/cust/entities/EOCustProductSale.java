package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUSTOMER_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.DISCOUNTS;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_SALE;
import static com.brijframework.production.contants.Constants.RETAIL_SALE_QNT;
import static com.brijframework.production.contants.Constants.RETAIL_SALE_TOTALS;
import static com.brijframework.production.contants.Constants.SALE_DATE;
import static com.brijframework.production.contants.Constants.WHOLE_SALE_QNT;
import static com.brijframework.production.contants.Constants.WHOLE_SALE_TOTALS;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = EOCUST_PRODUCT_SALE)
public class EOCustProductSale extends EOCustItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = DISCOUNTS)
	private Double discounts;

	@Column(name = RETAIL_SALE_TOTALS)
	private Double retailSaleTotals;

	@Column(name = WHOLE_SALE_TOTALS)
	private Double wholeSaleTotals;
	
	@Column(name = RETAIL_SALE_QNT)
	private Double retailSaleQnt;

	@Column(name = WHOLE_SALE_QNT)
	private Double wholeSaleQnt;
	
	@Column(name = SALE_DATE)
	@CreationTimestamp
	private Date  saleDate;
	
	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_PRODUCT_SALE)
	private List<EOCustProductRetailSale> custProductRetailSaleList;

	@OneToMany(mappedBy = CUST_PRODUCT_SALE)
	private List<EOCustProductWholeSale> custProductWholeSaleList;

	public Double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}

	public Double getRetailSaleTotals() {
		return retailSaleTotals;
	}

	public void setRetailSaleTotals(Double retailSaleTotals) {
		this.retailSaleTotals = retailSaleTotals;
	}

	public Double getWholeSaleTotals() {
		return wholeSaleTotals;
	}

	public void setWholeSaleTotals(Double wholeSaleTotals) {
		this.wholeSaleTotals = wholeSaleTotals;
	}

	public Double getRetailSaleQnt() {
		return retailSaleQnt;
	}

	public void setRetailSaleQnt(Double retailSaleQnt) {
		this.retailSaleQnt = retailSaleQnt;
	}

	public Double getWholeSaleQnt() {
		return wholeSaleQnt;
	}

	public void setWholeSaleQnt(Double wholeSaleQnt) {
		this.wholeSaleQnt = wholeSaleQnt;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustProductRetailSale> getCustProductRetailSaleList() {
		return custProductRetailSaleList;
	}

	public void setCustProductRetailSaleList(List<EOCustProductRetailSale> custProductRetailSaleList) {
		this.custProductRetailSaleList = custProductRetailSaleList;
	}

	public List<EOCustProductWholeSale> getCustProductWholeSaleList() {
		return custProductWholeSaleList;
	}

	public void setCustProductWholeSaleList(List<EOCustProductWholeSale> custProductWholeSaleList) {
		this.custProductWholeSaleList = custProductWholeSaleList;
	}
	
}
