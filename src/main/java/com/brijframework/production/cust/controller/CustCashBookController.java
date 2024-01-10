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
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.rest.CustCashBookRequest;
import com.brijframework.production.cust.rest.CustCashBookResponse;
import com.brijframework.production.cust.service.CustCashBookService;

@RestController
@RequestMapping("/api/cust/account/cashbook")
public class CustCashBookController {

	@Autowired
	private CustCashBookService custCashBookService;
	
	@PostMapping
	public CustCashBookResponse addCashBook(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustCashBookRequest custCashBookRequest) {
		return custCashBookService.saveCashBook(custAppId,custCashBookRequest);
	}
	
	@PutMapping
	public CustCashBookResponse updateCashBook(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody CustCashBookRequest custCashBookRequest) {
		return custCashBookService.saveCashBook(custAppId,custCashBookRequest);
	}
	
	@GetMapping
	public List<CustCashBookResponse> getCashBookList(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId) {
		return custCashBookService.getCashBookList(custAppId, userId);
	}
	
	@GetMapping("/{id}")
	public CustCashBookResponse getCashBookList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCashBookService.getCashBook(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCashBookList(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable("id") Long id) {
		return custCashBookService.deleteCashBook(custAppId,id);
	}
	
}
