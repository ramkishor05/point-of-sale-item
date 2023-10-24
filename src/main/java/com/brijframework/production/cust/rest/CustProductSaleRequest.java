package com.brijframework.production.cust.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustProductSaleRequest {

	private Long id;
	
	private String idenNo;
	
	private Double discounts;

	private Double retailSaleTotals;
	
	private Double retailSaleQnt;
	
	private Double wholeSaleTotals;
	
	private Double wholeSaleQnt;
	
	private Long custProductionAppId;
	
	private Long customerId;
	
	private List<CustProductRetailSaleRequest> custProductRetailSaleList;
	
	private List<CustProductWholeSaleRequest> custProductWholeSaleList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCustProductionAppId() {
		return custProductionAppId;
	}

	public void setCustProductionAppId(Long custProductionAppId) {
		this.custProductionAppId = custProductionAppId;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

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

	public List<CustProductRetailSaleRequest> getCustProductRetailSaleList() {
		return custProductRetailSaleList;
	}

	public void setCustProductRetailSaleList(List<CustProductRetailSaleRequest> custProductRetailSaleList) {
		this.custProductRetailSaleList = custProductRetailSaleList;
	}

	public List<CustProductWholeSaleRequest> getCustProductWholeSaleList() {
		return custProductWholeSaleList;
	}

	public void setCustProductWholeSaleList(List<CustProductWholeSaleRequest> custProductWholeSaleList) {
		this.custProductWholeSaleList = custProductWholeSaleList;
	}
	
}
