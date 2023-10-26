package com.brijframework.production.global.entities;

import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.EOGLOBAL_CURRENCY_ITEM;
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

import com.brijframework.production.entities.EOEntityObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name=EOGLOBAL_CURRENCY_ITEM ,  uniqueConstraints = { @UniqueConstraint (columnNames = {GROUP_ID, NAME})} )
public class EOGlobalCurrencyItem extends EOEntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name=TYPE_ID)
	public String typeId;
	
	@Column(name=NAME)
	public String name;
	
	@Column(name=DESCRIPTION)
	public String description;
	
	@OneToOne
	@JoinColumn(name = GLB_IMG_ID)
	public EOGlobalMediaDetail globalMediaDetail;

	@ManyToOne
	@JoinColumn(name = GROUP_ID, nullable = false)
	private EOGlobalCurrencyGroup globalCurrencyGroup;

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

	public EOGlobalMediaDetail getGlobalMediaDetail() {
		return globalMediaDetail;
	}

	public void setGlobalMediaDetail(EOGlobalMediaDetail globalMediaDetail) {
		this.globalMediaDetail = globalMediaDetail;
	}

	public EOGlobalCurrencyGroup getGlobalCurrencyGroup() {
		return globalCurrencyGroup;
	}

	public void setGlobalCurrencyGroup(EOGlobalCurrencyGroup globalCurrencyGroup) {
		this.globalCurrencyGroup = globalCurrencyGroup;
	}
	
	
}
