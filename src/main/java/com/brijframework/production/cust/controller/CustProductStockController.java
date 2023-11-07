package com.brijframework.production.cust.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.cust.repository.CustProductStockRepository.ProductStock;
import com.brijframework.production.cust.service.CustProductStockService;

@RestController
@RequestMapping("/api/cust/product/stock")
public class CustProductStockController {

	@Autowired
	private CustProductStockService custProductStockService;
	
	@GetMapping("/{productId}")
	public List<ProductStock> getProductStockList(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable("productId") Long productId) {
		return custProductStockService.getProductStockList(custAppId, productId);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProductStock(@RequestHeader(CUST_APP_ID) long custAppId, @PathVariable long id) {
		return custProductStockService.deleteProductStock(custAppId, id);
	}
	
}
