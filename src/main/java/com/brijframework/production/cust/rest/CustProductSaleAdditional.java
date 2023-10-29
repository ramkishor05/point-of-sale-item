package com.brijframework.production.cust.rest;

import com.brijframework.production.dto.UIComman;

public class CustProductSaleAdditional extends UIComman {

	private String field;

	private String value;

	private String type;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
