package com.brijframework.production.cust.entities;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID;
import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.EOCUST_CATEGORY;
import static com.brijframework.production.contants.Constants.GLB_IMG_ID;
import static com.brijframework.production.contants.Constants.GROUP_ID;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.production.global.entities.EOGlobalMediaDetail;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CATEGORY, uniqueConstraints = { @UniqueConstraint(columnNames = { CUST_PROD_APP_ID, GROUP_ID, NAME }) })
public class EOCustCategory extends EOCustObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = NAME)
	private String name;

	@Column(name = DESCRIPTION)
	private String description;

	@Column(name = TYPE_ID)
	private String typeId;
	
	@OneToOne
	@JoinColumn(name = GLB_IMG_ID)
	public EOGlobalMediaDetail custImageDetail;

	@JoinColumn(name = CUST_PROD_APP_ID, nullable = false)
	@ManyToOne
	private EOCustProductionApp custProductionApp;

	@ManyToOne
	@JoinColumn(name = GROUP_ID, nullable = false)
	private EOCustCategoryGroup custCategoryGroup;

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

	public EOCustProductionApp getCustProductionApp() {
		return custProductionApp;
	}

	public void setCustProductionApp(EOCustProductionApp custProductionApp) {
		this.custProductionApp = custProductionApp;
	}

	public EOCustCategoryGroup getCustCategoryGroup() {
		return custCategoryGroup;
	}

	public void setCustCategoryGroup(EOCustCategoryGroup custCategoryGroup) {
		this.custCategoryGroup = custCategoryGroup;
	}

	public EOGlobalMediaDetail getCustImageDetail() {
		return custImageDetail;
	}

	public void setCustImageDetail(EOGlobalMediaDetail custImageDetail) {
		this.custImageDetail = custImageDetail;
	}
	
	
}
