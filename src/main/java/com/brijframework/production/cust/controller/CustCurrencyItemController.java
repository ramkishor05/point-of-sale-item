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

import com.brijframework.production.cust.rest.CustCurrencyItemRequest;
import com.brijframework.production.cust.rest.CustCurrencyItemResponse;
import com.brijframework.production.cust.service.CustCurrencyItemService;

@RestController
@RequestMapping("/api/cust/currency/item")
public class CustCurrencyItemController {

	@Autowired
	private CustCurrencyItemService custCurrencyItemService;
	
	@PostMapping
	public CustCurrencyItemResponse addCurrencyItem(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustCurrencyItemRequest custCurrencyItemRequest) {
		return custCurrencyItemService.saveCurrencyItem(custAppId,custCurrencyItemRequest);
	}
	
	@PutMapping
	public CustCurrencyItemResponse updateCurrencyItem(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustCurrencyItemRequest custCurrencyItemRequest) {
		return custCurrencyItemService.saveCurrencyItem(custAppId,custCurrencyItemRequest);
	}
	
	@GetMapping
	public List<CustCurrencyItemResponse> getCurrencyItemList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custCurrencyItemService.getCurrencyItemList(custAppId);
	}
	
	@GetMapping("/{id}")
	public CustCurrencyItemResponse getCurrencyItemList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCurrencyItemService.getCurrencyItem(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCurrencyItemList(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable("id") Long id) {
		return custCurrencyItemService.deleteCurrencyItem(custAppId,id);
	}
	
	@GetMapping("/type/{typeId}")
	public List<CustCurrencyItemResponse> getCurrencyItemList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable(TYPE_ID) String typeId) {
		return custCurrencyItemService.findAllByType(custAppId,typeId);
	}
}
