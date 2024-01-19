package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_ACCOUNT_ID;
import static com.brijframework.production.contants.Constants.EOCUST_TRANSACTION;
import static com.brijframework.production.contants.Constants.TRANSACTION_AMOUNT;
import static com.brijframework.production.contants.Constants.TRANSACTION_DATE;
import static com.brijframework.production.contants.Constants.TRANSACTION_ID;
import static com.brijframework.production.contants.Constants.TRANSACTION_MAKER_ID;
import static com.brijframework.production.contants.Constants.TRANSACTION_MODE;
import static com.brijframework.production.contants.Constants.TRANSACTION_RECIVER_ID;
import static com.brijframework.production.contants.Constants.TRANSACTION_SENDER_ID;
import static com.brijframework.production.contants.Constants.TRANSACTION_SERVICE;
import static com.brijframework.production.contants.Constants.TRANSACTION_STATUS;
import static com.brijframework.production.contants.Constants.TRANSACTION_TYPE;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.brijframework.production.contants.TransactionMode;
import com.brijframework.production.contants.TransactionStatus;
import com.brijframework.production.contants.TransactionType;
import com.brijframework.production.entities.EOEntityObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_TRANSACTION)
public class EOCustTransaction extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = TRANSACTION_ID)
	private String transactionId;
	
	@Column(name = TRANSACTION_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date transactionDate;

	@Column(name = TRANSACTION_AMOUNT)
	private Double transactionAmount;
	
	@Column(name = TRANSACTION_STATUS)
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus; 
	
	@Column(name = TRANSACTION_TYPE)
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Column(name = TRANSACTION_MODE)
	@Enumerated(EnumType.STRING)
	private TransactionMode transactionMode;
	
	@Column(name = TRANSACTION_RECIVER_ID, nullable = false)
	private Long transactionReciverId;
	
	@Column(name = TRANSACTION_SENDER_ID, nullable = false)
	private Long transactionSenderId;
	
	@Column(name = TRANSACTION_MAKER_ID, nullable = false)
	private Long transactionMakerId;
	
	@Column(name = TRANSACTION_SERVICE, nullable = false)
	private String transactionService;
	
	@JoinColumn(name = CUST_ACCOUNT_ID, nullable = false)
	@ManyToOne
	private EOCustAccount custAccount;
	
	@PrePersist
	public void init() {
		transactionId=UUID.randomUUID().toString();
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

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Long getTransactionReciverId() {
		return transactionReciverId;
	}

	public void setTransactionReciverId(Long transactionReciverId) {
		this.transactionReciverId = transactionReciverId;
	}

	public Long getTransactionSenderId() {
		return transactionSenderId;
	}

	public void setTransactionSenderId(Long transactionSenderId) {
		this.transactionSenderId = transactionSenderId;
	}

	public Long getTransactionMakerId() {
		return transactionMakerId;
	}

	public void setTransactionMakerId(Long transactionMakerId) {
		this.transactionMakerId = transactionMakerId;
	}

	public EOCustAccount getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(EOCustAccount custAccount) {
		this.custAccount = custAccount;
	}

	public String getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(String transactionService) {
		this.transactionService = transactionService;
	}
	
	
	
}
