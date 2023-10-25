package com.brijframework.production.cust.entities;
import static com.brijframework.production.contants.Constants.APP_ID;
import static com.brijframework.production.contants.Constants.BUSINESS_ID;
import static com.brijframework.production.contants.Constants.CUST_ID;
import static com.brijframework.production.contants.Constants.CUST_PRODUCTION_APP;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCTION_APP;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCTION_APP, uniqueConstraints = {@UniqueConstraint (columnNames = { APP_ID, CUST_ID,BUSINESS_ID })})
public class EOCustProductionApp extends EOCustObject {

	private static final long serialVersionUID = 1L;

	@Column(name = APP_ID, nullable = false)
	private long appid;

	@Column(name = CUST_ID, nullable = false)
	private long custId;
	
	@Column(name = BUSINESS_ID, nullable = false)
	private long businessId;

	@OneToMany(mappedBy = CUST_PRODUCTION_APP)
	public Set<EOCustCountFreq> custCountFreqs;

	@OneToMany(mappedBy = CUST_PRODUCTION_APP)
	public Set<EOCustUnitGroup> custUnitGroups;
	
	@OneToMany(mappedBy = CUST_PRODUCTION_APP)
	public Set<EOCustCategoryGroup> custCategoryGroups;

	@OneToMany(mappedBy = CUST_PRODUCTION_APP)
	public Set<EOCustCategory> custCategories;

	@OneToMany(mappedBy = CUST_PRODUCTION_APP)
	public Set<EOCustProduct> custProducts;

	public long getAppid() {
		return appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public Set<EOCustCountFreq> getCustCountFreqs() {
		return custCountFreqs;
	}

	public void setCustCountFreqs(Set<EOCustCountFreq> custCountFreqs) {
		this.custCountFreqs = custCountFreqs;
	}

	public Set<EOCustUnitGroup> getCustUnitGroups() {
		return custUnitGroups;
	}

	public void setCustUnitGroups(Set<EOCustUnitGroup> custUnitGroups) {
		this.custUnitGroups = custUnitGroups;
	}

	public Set<EOCustCategoryGroup> getCustCategoryGroups() {
		return custCategoryGroups;
	}

	public void setCustCategoryGroups(Set<EOCustCategoryGroup> custCategoryGroups) {
		this.custCategoryGroups = custCategoryGroups;
	}

	public Set<EOCustCategory> getCustCategories() {
		return custCategories;
	}

	public void setCustCategories(Set<EOCustCategory> custCategories) {
		this.custCategories = custCategories;
	}

	public Set<EOCustProduct> getCustProducts() {
		return custProducts;
	}

	public void setCustProducts(Set<EOCustProduct> custProducts) {
		this.custProducts = custProducts;
	}

}
