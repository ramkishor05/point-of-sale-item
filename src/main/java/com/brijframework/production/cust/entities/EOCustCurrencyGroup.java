package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.*;
import static com.brijframework.production.contants.Constants.DISPLAY_NAME;
import static com.brijframework.production.contants.Constants.EOCUST_CURRENCY_GROUP;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.SHORT_DESC;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = EOCUST_CURRENCY_GROUP)
public class EOCustCurrencyGroup extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = TYPE_ID)
	public String typeId;
	
	@Column(name=NAME)
	public String name;
	
	@Column(name = SHORT_DESC)
	public String description;
	
	@Column(name = DISPLAY_NAME)
	public String displayName;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_CURRENCY_GROUP)
	public Set<EOCustCurrencyItem> custCurrencyItemList ;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

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