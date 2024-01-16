package com.brijframework.production.cust.rest;

import java.util.Date;

import com.brijframework.production.contants.TransactionMode;
import com.brijframework.production.contants.TransactionStatus;
import com.brijframework.production.contants.TransactionType;

public class CustTransationResponse {

	private String transactionId;
	private Date transactionDate;
	private Double transactionAmount;
	private TransactionStatus transactionStatus;
	private TransactionType transactionType;
	private TransactionMode transactionMode;
	private Long transactionReciverId;
	private Long transactionSenderId;
	private Long transactionMakerId;

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
}
