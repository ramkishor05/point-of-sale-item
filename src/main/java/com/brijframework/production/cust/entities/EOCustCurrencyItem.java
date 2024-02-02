package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_CURRENCY_GROUP_ID;
import static com.brijframework.production.contants.Constants.DISPLAY_NAME;
import static com.brijframework.production.contants.Constants.EOCUST_CURRENCY_ITEM;
import static com.brijframework.production.contants.Constants.SYMBOL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = EOCUST_CURRENCY_ITEM)
public class EOCustCurrencyItem extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = DISPLAY_NAME)
	public String displayName;
	
	@Column(name = SYMBOL)
	public String symbol;
		
	@ManyToOne
	@JoinColumn(name=CUST_CURRENCY_GROUP_ID)
	public EOCustCurrencyGroup  custCurrencyGroup;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public EOCustCurrencyGroup getCustCurrencyGroup() {
		return custCurrencyGroup;
	}

	public void setCustCurrencyGroup(EOCustCurrencyGroup custCurrencyGroup) {
		this.custCurrencyGroup = custCurrencyGroup;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}
	
}
