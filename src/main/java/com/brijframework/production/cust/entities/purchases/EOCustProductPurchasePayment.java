package com.brijframework.production.cust.entities.purchases;

import static com.brijframework.production.contants.Constants.SUPPLIER_ID;

import java.util.Date;

import static com.brijframework.production.contants.Constants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_PURCHASE_PAYMENT;
import static com.brijframework.production.contants.Constants.PURCHASE_DATE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.brijframework.production.contants.PaymentMode;
import com.brijframework.production.cust.entities.EOCustObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_PAYMENT)
public class EOCustProductPurchasePayment extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String TRANSACTION_DATE = "TRANSACTION_DATE";

	private static final String TRANSACTION_ID = "TRANSACTION_ID";

	@Column(name = "MODE")
	@Enumerated(EnumType.STRING)
	private PaymentMode mode;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;
	
	@Column(name = TRANSACTION_ID)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
	private String transactionId;
	
	@Column(name = TRANSACTION_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date transactionDate;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustProductPurchase custProductPurchase;

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public EOCustProductPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustProductPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	

}
