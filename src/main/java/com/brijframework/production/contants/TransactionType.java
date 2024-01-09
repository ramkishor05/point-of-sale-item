package com.brijframework.production.contants;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TransactionType {
	
	Credit("Credit"), Debit("Debit");
	
	String type;
	TransactionType(String type) {
		this.type=type;
	}

	@Override
	public String toString() {
		return type.toString();
	}
	
	
	@JsonCreator
	public static TransactionType forValue(String type)
	{
		System.out.println("type="+type);
	    return Arrays.asList(TransactionType.values()).stream().filter(pt -> pt.type.equalsIgnoreCase(type)).findFirst().get();
	}
}
