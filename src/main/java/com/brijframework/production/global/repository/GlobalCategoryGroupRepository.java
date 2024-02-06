package com.brijframework.production.global.repository;

import java.util.List;

import static com.brijframework.production.contants.Constants.POINT_OF_SALE_APP;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.brijframework.production.global.dto.UIGlobalCategoryGroup;

@FeignClient(name=POINT_OF_SALE_APP)
public interface GlobalCategoryGroupRepository {

	@GetMapping("/api/global/categorygroup")
	public List<UIGlobalCategoryGroup> findAll();
	
	
}
