package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_UNIT_GROUP_ID;
import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.DISPLAY_NAME;
import static com.brijframework.production.contants.Constants.EOCUST_UNIT;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = EOCUST_UNIT)
public class EOCustUnit extends EOCustObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = TYPE_ID)
	public String typeId;
	
	@Column(name = NAME)
	public String name;
	
	@Column(name = DESCRIPTION)
	public String description;
	
	@Column(name = DISPLAY_NAME)
	public String displayName;
		
	@ManyToOne
	@JoinColumn(name=CUST_UNIT_GROUP_ID)
	public EOCustUnitGroup  custUnitGroup;
	
	@JoinColumn(name = CUST_PROD_APP_ID, nullable = false)
	@ManyToOne
	private EOCustProductionApp custProductionApp;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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

	public EOCustUnitGroup getCustUnitGroup() {
		return custUnitGroup;
	}

	public void setCustUnitGroup(EOCustUnitGroup custUnitGroup) {
		this.custUnitGroup = custUnitGroup;
	}

	public EOCustProductionApp getCustProductionApp() {
		return custProductionApp;
	}

	public void setCustProductionApp(EOCustProductionApp custProductionApp) {
		this.custProductionApp = custProductionApp;
	}
	
}
