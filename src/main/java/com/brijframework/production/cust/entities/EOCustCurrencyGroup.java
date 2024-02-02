package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_CURRENCY_GROUP;
import static com.brijframework.production.contants.Constants.EOCUST_CURRENCY_GROUP;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = EOCUST_CURRENCY_GROUP)
public class EOCustCurrencyGroup extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_CURRENCY_GROUP)
	public Set<EOCustCurrencyItem> custCurrencyItemList ;

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public Set<EOCustCurrencyItem> getCustCurrencyItemList() {
		return custCurrencyItemList;
	}

	public void setCustCurrencyItemList(Set<EOCustCurrencyItem> custCurrencyItemList) {
		this.custCurrencyItemList = custCurrencyItemList;
	}

}