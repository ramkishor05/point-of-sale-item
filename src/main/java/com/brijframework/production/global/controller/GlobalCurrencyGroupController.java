package com.brijframework.production.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;
import com.brijframework.production.global.service.GlobalCurrencyGroupService;

@RestController
@RequestMapping("api/global/currency/group")
public class GlobalCurrencyGroupController {

	@Autowired
	GlobalCurrencyGroupService globalCurrencyGroupService;
	
	@PostMapping
	public UIGlobalCurrencyGroup addCurrencyGroup(@RequestBody UIGlobalCurrencyGroup globalCurrencyGroup) {
		return globalCurrencyGroupService.saveCurrencyGroup(globalCurrencyGroup);
	}
	
	@PutMapping
	public UIGlobalCurrencyGroup updateCurrencyGroup(@RequestBody UIGlobalCurrencyGroup globalCurrencyGroup) {
		return globalCurrencyGroupService.saveCurrencyGroup(globalCurrencyGroup);
	}
	
	@GetMapping
	public List<UIGlobalCurrencyGroup> getCurrencyGroupList() {
		return globalCurrencyGroupService.getCurrencyGroupList();
	}
	
	@GetMapping("/{id}")
	public UIGlobalCurrencyGroup getCurrencyList(@PathVariable("id") Long id) {
		return globalCurrencyGroupService.getCurrencyGroup(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCurrencyList(@PathVariable("id") Long id) {
		return globalCurrencyGroupService.deleteCurrencyGroup(id);
	}
	
	@GetMapping("/status/{status}")
	public List<UIGlobalCurrencyGroup> getCurrencyGroupList(@PathVariable("status") RecordStatus  dataStatus) {
		return globalCurrencyGroupService.getCurrencyGroupList(dataStatus);
	}
	
	@GetMapping("/type/{typeId}")
	public List<UIGlobalCurrencyGroup> getCurrencyGroupList(@PathVariable("typeId") String typeId) {
		return globalCurrencyGroupService.getCurrencyGroup(typeId);
	}
}
