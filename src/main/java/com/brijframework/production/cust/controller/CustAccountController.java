package com.brijframework.production.cust.controller;
import static com.brijframework.production.contants.Constants.CUST_APP_ID;
import static com.brijframework.production.contants.Constants.USER_APP_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.rest.CustAccountRequest;
import com.brijframework.production.cust.rest.CustAccountResponse;
import com.brijframework.production.cust.service.CustAccountService;

@RestController
@RequestMapping("/api/cust/account")
public class CustAccountController {

	@Autowired
	private CustAccountService custAccountService;
	
	@PostMapping
	public CustAccountResponse addAccount(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustAccountRequest custAccountRequest) {
		return custAccountService.saveAccount(custAppId,custAccountRequest);
	}
	
	@PutMapping
	public CustAccountResponse updateAccount(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustAccountRequest custAccountRequest) {
		return custAccountService.saveAccount(custAppId,custAccountRequest);
	}
	
	@GetMapping
	public List<CustAccountResponse> getAccountList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId) {
		return custAccountService.getAccountList(custAppId);
	}
	
	@GetMapping("/filted")
	public List<CustAccountResponse> getAccountFiltedList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestParam String startDate, @RequestParam String endDate) {
		return custAccountService.getAccountFiltedList(custAppId, startDate, endDate);
	}
	
	@GetMapping("/{id}")
	public CustAccountResponse getAccountList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custAccountService.getAccount(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteAccountList(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable("id") Long id) {
		return custAccountService.deleteAccount(custAppId,id);
	}
	
}
