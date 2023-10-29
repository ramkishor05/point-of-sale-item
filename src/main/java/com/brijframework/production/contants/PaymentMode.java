package com.brijframework.production.contants;

public enum PaymentMode {
	Unpaid("Unpaid"), Cash("Cash"), Online("Online");

	String mode;
	PaymentMode(String mode) {
		this.mode=mode;
	}

	@Override
	public String toString() {
		return mode.toString();
	}
	
}
