package com.brijframework.production.contants;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TransactionStatus {
	
	Unpaid("Unpaid"), 
	Paid("Paid"),
	
	;

	String mode;
	TransactionStatus(String mode) {
		this.mode=mode;
	}

	@Override
	public String toString() {
		return mode.toString();
	}
	
}
