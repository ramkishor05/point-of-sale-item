package com.brijframework.production.cust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.dto.UICustBusinessApp;
import com.brijframework.production.cust.dto.UICustBusinessAppDetail;
import com.brijframework.production.cust.service.CustBusinessAppService;

@RestController
@RequestMapping("api/cust/app")
public class CustApplicationController {

	@Autowired
	CustBusinessAppService custApplicationService;
	
	@PostMapping
	public UICustBusinessApp addCustBusiness(@RequestBody UICustBusinessApp inventoryApplication) {
		return custApplicationService.saveCustBusinessApp(inventoryApplication);
	}
	
	@GetMapping("/{appId}")
	public UICustBusinessApp getCustBusiness(@PathVariable("appId") long appId) {
		return custApplicationService.getCustBusinessApp(appId);
	}
	
	@GetMapping("/{appId}/detail")
	public UICustBusinessAppDetail getCustBusinessDetail(@PathVariable("appId") long appId) {
		return custApplicationService.getCustBusinessAppDetail(appId);
	}
	
	
}
