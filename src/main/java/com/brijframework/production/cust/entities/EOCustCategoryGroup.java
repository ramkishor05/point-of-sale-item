package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.CUST_CATEGORY_GROUP;
import static com.brijframework.production.contants.Constants.EOCUST_CATEGORY_GROUP;
import static com.brijframework.production.contants.Constants.NAME;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CATEGORY_GROUP, uniqueConstraints = { @UniqueConstraint(columnNames = { CUST_BUSINESS_APP_ID, NAME }) })
public class EOCustCategoryGroup extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_CATEGORY_GROUP)
	public Set<EOCustCategoryItem> custCategoryList;

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public Set<EOCustCategoryItem> getCustCategoryList() {
		return custCategoryList;
	}

	public void setCustCategoryList(Set<EOCustCategoryItem> custCategoryList) {
		this.custCategoryList = custCategoryList;
	}
}
