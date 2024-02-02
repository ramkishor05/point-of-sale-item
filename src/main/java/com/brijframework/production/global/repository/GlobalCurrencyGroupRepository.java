package com.brijframework.production.global.repository;

import static com.brijframework.production.contants.Constants.POINT_OF_SALE_APP;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;

@FeignClient(POINT_OF_SALE_APP)
public interface GlobalCurrencyGroupRepository {

	@GetMapping("/api/global/categorygroup")
	public List<UIGlobalCurrencyGroup> findAll() ;

}
