package com.brijframework.production.global.dto;

import java.io.Serializable;

public class UIGlobalUnitGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	public String typeId;
	public String description;
	public String name;
	public String displayName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


}
