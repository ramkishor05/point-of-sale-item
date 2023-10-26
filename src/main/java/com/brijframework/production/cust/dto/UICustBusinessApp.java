package com.brijframework.production.cust.dto;

public class UICustBusinessApp {

	private long id;

	private long appid;

	private long custId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "UIInventoryApplication [id=" + id + ", appid=" + appid + ", custId=" + custId + "]";
	}

}
