package com.brijframework.production.cust.entities.sales;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.production.contants.Constants.DISCOUNT;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_SALE_ITEM;
import static com.brijframework.production.contants.Constants.PURCHASE_PRICE;
import static com.brijframework.production.contants.Constants.SALE_PRICE;

import java.util.List;

import static com.brijframework.production.contants.Constants.*;

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

import com.brijframework.production.cust.entities.EOCustItem;
import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.entities.EOCustProductStock;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_SALE_ITEM)
public class EOCustProductSaleItem extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// for purchase cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustProductSaleItemPrice purchasePrice;

	// for sale cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = SALE_PRICE)
	private EOCustProductSaleItemPrice salePrice;

	@Column(name = SALE_QTN)
	private Long saleQnt;

	@Column(name = DISCOUNT)
	private Double discount;
	
	@Column(name = SALE_TYPE)
	private String saleType;

	@JoinColumn(name = CUST_PRODUCT_ID)
	@ManyToOne
	private EOCustProduct custProduct;

	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	@OneToOne
	private EOCustProductSale custProductSale;
	
	@OneToMany(mappedBy = "custProductSaleItem")
	private List<EOCustProductStock> custProductStockList;

	public EOCustProductSaleItemPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductSaleItemPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustProductSaleItemPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(EOCustProductSaleItemPrice salePrice) {
		this.salePrice = salePrice;
	}

	public Long getSaleQnt() {
		return saleQnt;
	}

	public void setSaleQnt(Long saleQnt) {
		this.saleQnt = saleQnt;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
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
