package com.brijframework.production.cust.rest;

import java.io.Serializable;

import com.brijframework.production.cust.dto.UICustCategoryGroup;
import com.brijframework.production.cust.dto.UICustMediaDetail;

public class CustCategoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	public String idenNo;
	public String name;
	public String desc;
	public String typeId;
	public String logoUrl;
	public long custCategoryGroupId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public long getCustCategoryGroupId() {
		return custCategoryGroupId;
	}

	public void setCustCategoryGroupId(long custCategoryGroupId) {
		this.custCategoryGroupId = custCategoryGroupId;
	}

}
