package com.brijframework.production.global.entities;

import static com.brijframework.production.contants.Constants.DESCRIPTION;
import static com.brijframework.production.contants.Constants.DISPLAY_NAME;
import static com.brijframework.production.contants.Constants.EOGLOBAL_UNIT;
import static com.brijframework.production.contants.Constants.GROUP_ID;
import static com.brijframework.production.contants.Constants.LONG_DESC;
import static com.brijframework.production.contants.Constants.NAME;
import static com.brijframework.production.contants.Constants.TYPE_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.production.entities.EOEntityObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOGLOBAL_UNIT, uniqueConstraints = { @UniqueConstraint(columnNames = {GROUP_ID, NAME }) })
public class EOGlobalUnit extends EOEntityObject{
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
	
	@Column(name=DISPLAY_NAME)
	public String displayName;
		
	@ManyToOne
	@JoinColumn(name=GROUP_ID)
	public EOGlobalUnitGroup  unitGroup;

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public EOGlobalUnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(EOGlobalUnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}
}
