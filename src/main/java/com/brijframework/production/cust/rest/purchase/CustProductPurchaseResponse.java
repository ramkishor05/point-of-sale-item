package com.brijframework.production.cust.rest.purchase;

import java.util.List;

public class CustProductPurchaseResponse {
	private Long id;

	private String idenNo;

	private String purchaseDate;

	private Double discounts;

	private Double totalPrice;

	private Double totalQnt;

	private Long supplierId;
	
	private Long custBusinessAppId;

	private List<CustProductPurchaseItemResponse> custProductPurchaseItemList;

	private List<CustProductPurchaseAdditional> custProductPurchaseAdditionalList;

	private List<CustProductPurchasePayment> custProductPurchasePaymentList;

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

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public List<CustProductPurchaseItemResponse> getCustProductPurchaseItemList() {
		return custProductPurchaseItemList;
	}

	public void setCustProductPurchaseItemList(List<CustProductPurchaseItemResponse> custProductPurchaseItemList) {
		this.custProductPurchaseItemList = custProductPurchaseItemList;
	}

	public List<CustProductPurchaseAdditional> getCustProductPurchaseAdditionalList() {
		return custProductPurchaseAdditionalList;
	}

	public void setCustProductPurchaseAdditionalList(
			List<CustProductPurchaseAdditional> custProductPurchaseAdditionalList) {
		this.custProductPurchaseAdditionalList = custProductPurchaseAdditionalList;
	}

	public List<CustProductPurchasePayment> getCustProductPurchasePaymentList() {
		return custProductPurchasePaymentList;
	}

	public void setCustProductPurchasePaymentList(List<CustProductPurchasePayment> custProductPurchasePaymentList) {
		this.custProductPurchasePaymentList = custProductPurchasePaymentList;
	}

}
