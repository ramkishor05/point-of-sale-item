package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.production.contants.Constants.DISCOUNT;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_RETAIL_SALE;
import static com.brijframework.production.contants.Constants.PURCHASE_PRICE;
import static com.brijframework.production.contants.Constants.RETAIL_PRICE;
import static com.brijframework.production.contants.Constants.RETAIL_QTN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_RETAIL_SALE)
public class EOCustProductRetailSale extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// for purchase cost
	@OneToOne
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustProductRetailSalePrice purchasePrice;

	// for sale cost
	@OneToOne
	@JoinColumn(name = RETAIL_PRICE)
	private EOCustProductRetailSalePrice retailPrice;

	@Column(name = RETAIL_QTN)
	private Long retailQnt;

	@Column(name = DISCOUNT)
	private Double discount;

	@JoinColumn(name = CUST_PRODUCT_ID)
	@ManyToOne
	private EOCustProduct custProduct;

	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	@OneToOne
	private EOCustProductSale custProductSale;

	public EOCustProductRetailSalePrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductRetailSalePrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustProductRetailSalePrice getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(EOCustProductRetailSalePrice retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Long getRetailQnt() {
		return retailQnt;
	}

	public void setRetailQnt(Long retailQnt) {
		this.retailQnt = retailQnt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public EOCustProduct getCustProduct() {
		return custProduct;
	}

	public void setCustProduct(EOCustProduct custProduct) {
		this.custProduct = custProduct;
	}

	public EOCustProductSale getCustProductSale() {
		return custProductSale;
	}

	public void setCustProductSale(EOCustProductSale custProductSale) {
		this.custProductSale = custProductSale;
	}

}
