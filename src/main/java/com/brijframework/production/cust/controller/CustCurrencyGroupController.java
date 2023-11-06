package com.brijframework.production.cust.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;

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

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.dto.UICustCurrencyGroup;
import com.brijframework.production.cust.service.CustCurrencyGroupService;

@RestController
@RequestMapping("api/cust/currency/group")
public class CustCurrencyGroupController {

	@Autowired
	CustCurrencyGroupService custCurrencyGroupService;
	
	@PostMapping
	public UICustCurrencyGroup addCurrencyGroup(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UICustCurrencyGroup custCurrencyGroup) {
		return custCurrencyGroupService.saveCurrencyGroup(custAppId,custCurrencyGroup);
	}
	
	@PutMapping
	public UICustCurrencyGroup updateCurrencyGroup(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UICustCurrencyGroup custCurrencyGroup) {
		return custCurrencyGroupService.saveCurrencyGroup(custAppId,custCurrencyGroup);
	}
	
	@GetMapping
	public List<UICustCurrencyGroup> getCurrencyGroupList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custCurrencyGroupService.getCurrencyGroupList(custAppId);
	}
	
	@GetMapping("/{id}")
	public UICustCurrencyGroup getCurrencyList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCurrencyGroupService.getCurrencyGroup(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCurrencyList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCurrencyGroupService.deleteCurrencyGroup(custAppId,id);
	}
	
	@GetMapping("/status/{status}")
	public List<UICustCurrencyGroup> getCurrencyGroupList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("status") RecordStatus  dataStatus) {
		return custCurrencyGroupService.getCurrencyGroupListByStatus(custAppId,dataStatus);
	}
	
	@GetMapping("/type/{typeId}")
	public List<UICustCurrencyGroup> getCurrencyGroupList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("typeId") String typeId) {
		return custCurrencyGroupService.getCurrencyGroupListByType(custAppId,typeId);
	}
}
