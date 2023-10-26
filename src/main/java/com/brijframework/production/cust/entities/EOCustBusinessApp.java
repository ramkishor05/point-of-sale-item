package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.APP_ID;
import static com.brijframework.production.contants.Constants.BUSINESS_ID;
import static com.brijframework.production.contants.Constants.CUST_ID;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP;
import static com.brijframework.production.contants.Constants.EOCUST_BUSINESS_APP;

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
@Table(name = EOCUST_BUSINESS_APP, uniqueConstraints = {
		@UniqueConstraint(columnNames = { APP_ID, CUST_ID, BUSINESS_ID }) })
public class EOCustBusinessApp extends EOCustObject {

	private static final long serialVersionUID = 1L;

	@Column(name = APP_ID, nullable = false)
	private long appid;

	@Column(name = CUST_ID, nullable = false)
	private long custId;

	@Column(name = BUSINESS_ID, nullable = false)
	private long businessId;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustCountFreq> custCountFreqList;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustUnitGroup> custUnitGroupList;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustCategoryGroup> custCategoryGroups;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustCategoryItem> custCategoryList;

	@OneToMany(mappedBy = CUST_BUSINESS_APP)
	public Set<EOCustProduct> custProductList;

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

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public Set<EOCustCountFreq> getCustCountFreqList() {
		return custCountFreqList;
	}

	public void setCustCountFreqList(Set<EOCustCountFreq> custCountFreqList) {
		this.custCountFreqList = custCountFreqList;
	}

	public Set<EOCustUnitGroup> getCustUnitGroupList() {
		return custUnitGroupList;
	}

	public void setCustUnitGroupList(Set<EOCustUnitGroup> custUnitGroupList) {
		this.custUnitGroupList = custUnitGroupList;
	}

	public Set<EOCustCategoryGroup> getCustCategoryGroups() {
		return custCategoryGroups;
	}

	public void setCustCategoryGroups(Set<EOCustCategoryGroup> custCategoryGroups) {
		this.custCategoryGroups = custCategoryGroups;
	}

	public Set<EOCustCategoryItem> getCustCategoryList() {
		return custCategoryList;
	}

	public void setCustCategoryList(Set<EOCustCategoryItem> custCategoryList) {
		this.custCategoryList = custCategoryList;
	}

	public Set<EOCustProduct> getCustProductList() {
		return custProductList;
	}

	public void setCustProductList(Set<EOCustProduct> custProductList) {
		this.custProductList = custProductList;
	}

}
