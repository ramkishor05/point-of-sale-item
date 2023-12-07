package com.brijframework.production.cust.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;
import static com.brijframework.production.contants.Constants.TYPE_ID;
import static com.brijframework.production.contants.Constants.USER_APP_ID;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.brijframework.production.cust.rest.purchase.CustProductPurchaseRequest;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseResponse;
import com.brijframework.production.cust.service.CustProductPurchaseService;

@RestController
@RequestMapping("/api/cust/purchases")
public class CustPurchaseController {

	
	@Autowired
	private CustProductPurchaseService custProductPurchaseService;
	
	@PostMapping
	public CustProductPurchaseResponse addProductPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId, @RequestBody CustProductPurchaseRequest custProductPurchaseRequest) {
		custProductPurchaseRequest.setUserId(userId);
		return custProductPurchaseService.saveProductPurchase(custAppId,custProductPurchaseRequest);
	}
	
	@PutMapping
	public CustProductPurchaseResponse updateProductPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestBody CustProductPurchaseRequest custProductPurchaseRequest) {
		custProductPurchaseRequest.setUserId(userId);
		return custProductPurchaseService.updateProductPurchase(custAppId,custProductPurchaseRequest);
	}
	
	@GetMapping
	public List<CustProductPurchaseResponse> getProductPurchaseList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custProductPurchaseService.getProductPurchaseList(custAppId);
	}
	
	@GetMapping("/supplier/{supplierId}")
	public List<CustProductPurchaseResponse> getProductPurchaseListBySupplier(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable Long supplierId) {
		return custProductPurchaseService.getProductPurchaseListBySupplier(custAppId, supplierId);
	}
	
	@GetMapping("/user/{userId}")
	public List<CustProductPurchaseResponse> getProductPurchaseListByUser(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable Long userId) {
		return custProductPurchaseService.getProductPurchaseListByUser(custAppId, userId);
	}
	
	@GetMapping("/type/{typeId}")
	public CustProductPurchaseResponse getProductPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable(TYPE_ID) String typeId) {
		return custProductPurchaseService.getProductPurchase(custAppId, typeId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProductPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custProductPurchaseService.deleteProductPurchase(custAppId, id);
	}
	
	@GetMapping("/filter")
	public List<CustProductPurchaseResponse> filterProductPurchaseList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate, @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {
		return custProductPurchaseService.filterProductPurchaseList(custAppId, fromDate, toDate);
	}
	
	@GetMapping("/filter/supplier/{supplierId}")
	public List<CustProductPurchaseResponse> filterProductPurchaseList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("supplierId") Long supplierId, @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate, @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {
		return custProductPurchaseService.filterProductPurchaseList(custAppId, supplierId, fromDate, toDate);
	}
}
