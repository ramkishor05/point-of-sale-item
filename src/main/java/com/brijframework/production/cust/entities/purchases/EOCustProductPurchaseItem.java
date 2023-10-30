package com.brijframework.production.cust.entities.purchases;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PURCHASE_ITEM;
import static com.brijframework.production.contants.Constants.PURCHASE_PRICE;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.brijframework.production.cust.entities.EOCustItem;
import com.brijframework.production.cust.entities.EOCustProduct;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_ITEM)
public class EOCustProductPurchaseItem extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// for purchase cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustProductPurchaseItemPrice purchasePrice;
	
	@Column(name = "DISCOUNT")
	private Double discount;

	@Column(name = "PURCHASE_QNT")
	private Double purchaseQnt;

	@JoinColumn(name = CUST_PRODUCT_ID)
	@ManyToOne
	private EOCustProduct custProduct;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustProductPurchase custProductPurchase;

	public EOCustProductPurchaseItemPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductPurchaseItemPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getPurchaseQnt() {
		return purchaseQnt;
	}

	public void setPurchaseQnt(Double purchaseQnt) {
		this.purchaseQnt = purchaseQnt;
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

	public EOCustProductPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustProductPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}

	
}
