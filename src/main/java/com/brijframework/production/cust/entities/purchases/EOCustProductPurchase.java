package com.brijframework.production.cust.entities.purchases;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE;
import static com.brijframework.production.contants.Constants.DISCOUNTS;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PURCHASE;
import static com.brijframework.production.contants.Constants.PURCHASE_DATE;
import static com.brijframework.production.contants.Constants.SUPPLIER_ID;
import static com.brijframework.production.contants.Constants.TOTAL_PRICE;
import static com.brijframework.production.contants.Constants.TOTAL_QNT;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustItem;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE)
public class EOCustProductPurchase extends EOCustItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = DISCOUNTS)
	private Double discounts;

	@Column(name = TOTAL_PRICE)
	private Double totalPrice;
	
	@Column(name = TOTAL_QNT)
	private Double totalQnt;
	
	@Column(name = PURCHASE_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date  purchaseDate;
	
	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_PRODUCT_PURCHASE, cascade = CascadeType.ALL)
	private List<EOCustProductPurchaseItem> custProductPurchaseItemList;

	@OneToMany(mappedBy = CUST_PRODUCT_PURCHASE, cascade = CascadeType.ALL)
	private List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionalList;
	
	@OneToMany(mappedBy = CUST_PRODUCT_PURCHASE, cascade = CascadeType.ALL)
	private List<EOCustProductPurchasePayment> custProductPurchasePaymentList;

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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustProductPurchaseItem> getCustProductPurchaseItemList() {
		return custProductPurchaseItemList;
	}

	public void setCustProductPurchaseItemList(List<EOCustProductPurchaseItem> custProductPurchaseItemList) {
		this.custProductPurchaseItemList = custProductPurchaseItemList;
	}

	public List<EOCustProductPurchaseAdditional> getCustProductPurchaseAdditionalList() {
		return custProductPurchaseAdditionalList;
	}

	public void setCustProductPurchaseAdditionalList(
			List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionalList) {
		this.custProductPurchaseAdditionalList = custProductPurchaseAdditionalList;
	}

	public List<EOCustProductPurchasePayment> getCustProductPurchasePaymentList() {
		return custProductPurchasePaymentList;
	}

	public void setCustProductPurchasePaymentList(List<EOCustProductPurchasePayment> custProductPurchasePaymentList) {
		this.custProductPurchasePaymentList = custProductPurchasePaymentList;
	}
	
}
