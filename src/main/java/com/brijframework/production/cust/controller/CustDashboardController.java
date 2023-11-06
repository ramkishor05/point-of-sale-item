package com.brijframework.production.cust.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.rest.CustDashboardResponse;
import com.brijframework.production.cust.service.CustDashboardService;

@RestController
@RequestMapping("/api/cust/dashboard")
public class CustDashboardController {

	@Autowired
	private CustDashboardService custDashboardService;
	
	@GetMapping
	public CustDashboardResponse getDashboardList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custDashboardService.getDashboard(custAppId);
	}
	
}
