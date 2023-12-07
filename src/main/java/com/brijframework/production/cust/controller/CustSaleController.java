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

import com.brijframework.production.cust.rest.sale.CustProductSaleRequest;
import com.brijframework.production.cust.rest.sale.CustProductSaleResponse;
import com.brijframework.production.cust.service.CustProductSaleService;

@RestController
@RequestMapping("/api/cust/sales")
public class CustSaleController {

	@Autowired
	private CustProductSaleService custProductSaleService;
	
	@PostMapping
	public CustProductSaleResponse addProductSale(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestBody CustProductSaleRequest custProductSaleRequest) {
		custProductSaleRequest.setUserId(userId);
		return custProductSaleService.saveProductSale(custAppId,custProductSaleRequest);
	}
	@PutMapping
	public CustProductSaleResponse updateProductSale(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestBody CustProductSaleRequest custProductSaleRequest) {
		custProductSaleRequest.setUserId(userId);
		return custProductSaleService.updateProductSale(custAppId,custProductSaleRequest);
	}
	
	@GetMapping
	public List<CustProductSaleResponse> getProductList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custProductSaleService.getProductSaleList(custAppId);
	}
	
	@GetMapping("/type/{typeId}")
	public CustProductSaleResponse getProductSale(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable(TYPE_ID) String typeId) {
		return custProductSaleService.getProductSale(custAppId, typeId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProductSale(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custProductSaleService.deleteProductSale(custAppId, id);
	}
	
	@GetMapping("/filter")
	public List<CustProductSaleResponse> filterProductList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate, @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {
		return custProductSaleService.filterProductSaleList(custAppId, fromDate, toDate);
	}
	
	@GetMapping("/customer/{customerId}")
	public List<CustProductSaleResponse> getProductSaleListBySupplier(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable Long customerId) {
		return custProductSaleService.getProductSaleListBySupplier(custAppId, customerId);
	}
	
	@GetMapping("/user/{userId}")
	public List<CustProductSaleResponse> getProductSaleListByUser(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable Long userId) {
		return custProductSaleService.getProductSaleListByUser(custAppId, userId);
	}
}
