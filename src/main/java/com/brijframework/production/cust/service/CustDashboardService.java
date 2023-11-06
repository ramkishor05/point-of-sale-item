package com.brijframework.production.cust.service;

import com.brijframework.production.cust.rest.CustDashboardResponse;

public interface CustDashboardService {

	CustDashboardResponse getDashboard(long custAppId);
}
