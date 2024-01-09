package com.brijframework.production.contants;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TransactionMode {
	
	Unpaid("Unpaid"), Cash("Cash"), Online("Online");

	String mode;
	TransactionMode(String mode) {
		this.mode=mode;
	}

	@Override
	public String toString() {
		return mode.toString();
	}
	
}
