package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_UNIT_GROUP;
import static com.brijframework.production.contants.Constants.DISPLAY_NAME;
import static com.brijframework.production.contants.Constants.EOCUST_UNIT_GROUP;
import static com.brijframework.production.contants.Constants.LONG_DESC;
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
@Table(name = EOCUST_UNIT_GROUP)
public class EOCustUnitGroup extends EOCustObject {

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

	@JoinColumn(name = CUST_PROD_APP_ID, nullable = false)
	@ManyToOne
	private EOCustProductionApp custProductionApp;

	@OneToMany(mappedBy = CUST_UNIT_GROUP)
	public Set<EOCustUnit> custUnits ;

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

	public EOCustProductionApp getCustProductionApp() {
		return custProductionApp;
	}

	public void setCustProductionApp(EOCustProductionApp custProductionApp) {
		this.custProductionApp = custProductionApp;
	}

	public Set<EOCustUnit> getCustUnits() {
		return custUnits;
	}

	public void setCustUnits(Set<EOCustUnit> custUnits) {
		this.custUnits = custUnits;
	}
}