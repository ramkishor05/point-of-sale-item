package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.EOCUST_COUNT_FREQ;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = EOCUST_COUNT_FREQ, uniqueConstraints = {
		@UniqueConstraint(columnNames = { CUST_BUSINESS_APP_ID, NAME }) })
public class EOCustCountFreq extends EOCustObject {

	private static final long serialVersionUID = 1L;

	@Column(name = NAME)
	public String name;

	@Column(name = DESCRIPTION)
	public String description;

	@Column(name = TYPE_ID)
	public String typeId;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

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

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

}
