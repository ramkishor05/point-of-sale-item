package com.brijframework.production.contants;

import java.util.Arrays;
import java.util.List;

public enum DataStatus {
  
	ACTIVETED("ACTIVETED", Arrays.asList("ACTIVETED")), DACTIVETED("DACTIVETED",Arrays.asList("DACTIVETED")), ALL("All", Arrays.asList("ACTIVETED","DACTIVETED"));
	
	String status;
	List<String> statusIds;

	DataStatus(String status, List<String> statusIds) {
		this.status=status;
		this.statusIds=statusIds;
	}

	public String getStatus() {
		return status;
	}

	public List<String> getStatusIds() {
		return statusIds;
	}
	
}
