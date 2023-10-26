package com.brijframework.production.cust.entities;

import static com.brijframework.production.contants.Constants.CUST_CATEGORY_GROUP;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.EOCUST_CATEGORY_GROUP;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import java.util.Set;

import javax.persistence.Column;
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
public class EOCustCategoryGroup extends EOCustObject{

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
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_CATEGORY_GROUP)
	public Set<EOCustCategoryItem> custCategoryList;

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

	public Set<EOCustCategoryItem> getCustCategoryList() {
		return custCategoryList;
	}

	public void setCustCategoryList(Set<EOCustCategoryItem> custCategoryList) {
		this.custCategoryList = custCategoryList;
	}
}
