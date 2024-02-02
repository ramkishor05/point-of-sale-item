package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.EOCUST_CATEGORY_ITEM;
import static com.brijframework.production.contants.Constants.GROUP_ID;
import static com.brijframework.production.contants.Constants.NAME;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CATEGORY_ITEM, uniqueConstraints = {
		@UniqueConstraint(columnNames = { CUST_BUSINESS_APP_ID, GROUP_ID, NAME }) })
public class EOCustCategoryItem extends EOCustItem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@ManyToOne
	@JoinColumn(name = GROUP_ID, nullable = false)
	private EOCustCategoryGroup custCategoryGroup;

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public EOCustCategoryGroup getCustCategoryGroup() {
		return custCategoryGroup;
	}

	public void setCustCategoryGroup(EOCustCategoryGroup custCategoryGroup) {
		this.custCategoryGroup = custCategoryGroup;
	}

}
