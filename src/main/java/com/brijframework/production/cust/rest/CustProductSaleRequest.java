package com.brijframework.production.cust.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CustProductSaleRequest {

	private Long id;
	
	private String idenNo;
	
	private String  saleDate;
	
	private Double discounts;

	private Double totalPrice;
	
	private Double totalQnt;

	private Long custBusinessAppId;
	
	private Long customerId;
	
	private List<CustProductSaleItemRequest> custProductSaleItemList;
	
	private List<CustProductSaleAdditional> custProductSaleAdditionalList;
	
	private List<CustProductSalePayment> custProductSalePaymentList;

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

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public Double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalQnt() {
		return totalQnt;
	}

	public void setTotalQnt(Double totalQnt) {
		this.totalQnt = totalQnt;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<CustProductSaleItemRequest> getCustProductSaleItemList() {
		return custProductSaleItemList;
	}

	public void setCustProductSaleItemList(List<CustProductSaleItemRequest> custProductSaleItemList) {
		this.custProductSaleItemList = custProductSaleItemList;
	}

	public List<CustProductSaleAdditional> getCustProductSaleAdditionalList() {
		return custProductSaleAdditionalList;
	}

	public void setCustProductSaleAdditionalList(List<CustProductSaleAdditional> custProductSaleAdditionalList) {
		this.custProductSaleAdditionalList = custProductSaleAdditionalList;
	}

	public List<CustProductSalePayment> getCustProductSalePaymentList() {
		return custProductSalePaymentList;
	}

	public void setCustProductSalePaymentList(List<CustProductSalePayment> custProductSalePaymentList) {
		this.custProductSalePaymentList = custProductSalePaymentList;
	}

}
