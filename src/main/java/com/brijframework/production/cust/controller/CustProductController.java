package com.brijframework.production.cust.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;
import static com.brijframework.production.contants.Constants.TYPE_ID;

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
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.rest.CustProductRequest;
import com.brijframework.production.cust.rest.CustProductResponse;
import com.brijframework.production.cust.service.CustProductService;

@RestController
@RequestMapping("/api/cust/product")
public class CustProductController {

	@Autowired
	private CustProductService custProductService;
	
	@PostMapping
	public CustProductResponse addProduct(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustProductRequest product) {
		return custProductService.saveProduct(custAppId,product);
	}
	
	@PutMapping
	public CustProductResponse updateProduct(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustProductRequest product) {
		return custProductService.updateProduct(custAppId,product);
	}
	
	@GetMapping
	public List<CustProductResponse> getProductList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custProductService.getProductList(custAppId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProduct(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable long id) {
		return custProductService.deleteProduct(custAppId, id);
	}
	
	@GetMapping("/type/{typeId}")
	public CustProductResponse getProductList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable(TYPE_ID) String typeId) {
		return custProductService.getProduct(custAppId, typeId);
	}
}
