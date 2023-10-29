package com.brijframework.production.cust.entities.sales;

import static com.brijframework.production.contants.Constants.CUSTOMER_ID;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE;
import static com.brijframework.production.contants.Constants.DISCOUNTS;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_SALE;
import static com.brijframework.production.contants.Constants.SALE_DATE;
import static com.brijframework.production.contants.Constants.TOTAL_PRICE;
import static com.brijframework.production.contants.Constants.TOTAL_QNT;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustItem;


@Entity
@Table(name = EOCUST_PRODUCT_SALE)
public class EOCustProductSale extends EOCustItem {


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

	@Column(name = SALE_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date  saleDate;
	
	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_PRODUCT_SALE, cascade = CascadeType.ALL)
	private List<EOCustProductSaleItem> custProductSaleItemList;
	
	@OneToMany(mappedBy = CUST_PRODUCT_SALE, cascade = CascadeType.ALL)
	private List<EOCustProductSaleAdditional> custProductSaleAdditionalList;
	
	@OneToMany(mappedBy = CUST_PRODUCT_SALE, cascade = CascadeType.ALL)
	private List<EOCustProductSalePayment> custProductSalePaymentList;

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

	public List<EOCustProductSaleItem> getCustProductSaleItemList() {
		return custProductSaleItemList;
	}

	public void setCustProductSaleItemList(List<EOCustProductSaleItem> custProductSaleItemList) {
		this.custProductSaleItemList = custProductSaleItemList;
	}

	public List<EOCustProductSaleAdditional> getCustProductSaleAdditionalList() {
		return custProductSaleAdditionalList;
	}

	public void setCustProductSaleAdditionalList(List<EOCustProductSaleAdditional> custProductSaleAdditionalList) {
		this.custProductSaleAdditionalList = custProductSaleAdditionalList;
	}

	public List<EOCustProductSalePayment> getCustProductSalePaymentList() {
		return custProductSalePaymentList;
	}

	public void setCustProductSalePaymentList(List<EOCustProductSalePayment> custProductSalePaymentList) {
		this.custProductSalePaymentList = custProductSalePaymentList;
	}
	
}
