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

import com.brijframework.production.cust.rest.CustTransationRequest;
import com.brijframework.production.cust.rest.CustTransationResponse;
import com.brijframework.production.cust.service.CustTransationService;

@RestController
@RequestMapping("/api/cust/account/transation")
public class CustTransationController {

	@Autowired
	private CustTransationService custTransationService;
	
	@PostMapping
	public CustTransationResponse addTransation(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustTransationRequest custTransationRequest) {
		return custTransationService.saveTransation(custAppId,custTransationRequest);
	}
	
	@PutMapping
	public CustTransationResponse updateTransation(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustTransationRequest custTransationRequest) {
		return custTransationService.saveTransation(custAppId,custTransationRequest);
	}
	
	@GetMapping
	public List<CustTransationResponse> getTransationList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId) {
		return custTransationService.getTransationList(custAppId, userId);
	}
	
	@GetMapping("/filted")
	public List<CustTransationResponse> getTransationFiltedList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestParam String startDate, @RequestParam String endDate) {
		return custTransationService.getTransationFiltedList(custAppId, userId, startDate, endDate);
	}
	
	@GetMapping("/{id}")
	public CustTransationResponse getTransationList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custTransationService.getTransation(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteTransationList(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable("id") Long id) {
		return custTransationService.deleteTransation(custAppId,id);
	}
	
}
