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
import com.brijframework.production.cust.dto.UICustCategoryGroup;
import com.brijframework.production.cust.service.CustCategoryGroupService;

@RestController
@RequestMapping("api/cust/categorygroup")
public class CustCategoryGroupController {

	@Autowired
	CustCategoryGroupService custCategoryGroupService;
	
	@PostMapping
	public UICustCategoryGroup addCategoryGroup(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UICustCategoryGroup custCategoryGroup) {
		return custCategoryGroupService.saveCategoryGroup(custAppId,custCategoryGroup);
	}
	
	@PutMapping
	public UICustCategoryGroup updateCategoryGroup(@RequestHeader(CUST_APP_ID) long custAppId,@RequestBody UICustCategoryGroup custCategoryGroup) {
		return custCategoryGroupService.saveCategoryGroup(custAppId,custCategoryGroup);
	}
	
	@GetMapping
	public List<UICustCategoryGroup> getCategoryGroupList(@RequestHeader(CUST_APP_ID) long custAppId) {
		return custCategoryGroupService.getCategoryGroupList(custAppId);
	}
	
	@GetMapping("/{id}")
	public UICustCategoryGroup getCategoryList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCategoryGroupService.getCategoryGroup(custAppId,id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCategoryList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") Long id) {
		return custCategoryGroupService.deleteCategoryGroup(custAppId,id);
	}
	
	@GetMapping("/status/{status}")
	public List<UICustCategoryGroup> getCategoryGroupList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("status") RecordStatus  dataStatus) {
		return custCategoryGroupService.getCategoryGroupListByStatus(custAppId,dataStatus);
	}
	
	@GetMapping("/type/{typeId}")
	public List<UICustCategoryGroup> getCategoryGroupList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("typeId") String typeId) {
		return custCategoryGroupService.getCategoryGroupListByType(custAppId,typeId);
	}
}
