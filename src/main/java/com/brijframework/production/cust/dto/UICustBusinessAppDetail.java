package com.brijframework.production.cust.dto;

import java.util.Set;

import com.brijframework.production.global.dto.UIGlobalCountFreq;
import com.brijframework.production.global.dto.UIGlobalUnitGroup;

public class UICustBusinessAppDetail extends UICustBusinessApp {

	public Set<UIGlobalCountFreq> custCountFreqs;

	public Set<UIGlobalUnitGroup> custUnitGroups;

	public Set<UIGlobalCountFreq> getCustCountFreqs() {
		return custCountFreqs;
	}

	public void setCustCountFreqs(Set<UIGlobalCountFreq> custCountFreqs) {
		this.custCountFreqs = custCountFreqs;
	}

	public Set<UIGlobalUnitGroup> getCustUnitGroups() {
		return custUnitGroups;
	}

	public void setCustUnitGroups(Set<UIGlobalUnitGroup> custUnitGroups) {
		this.custUnitGroups = custUnitGroups;
	}
	
}
