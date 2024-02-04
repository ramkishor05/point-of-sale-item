package com.brijframework.production.global.repository;

import static com.brijframework.production.contants.Constants.POINT_OF_SALE_APP;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;

@FeignClient(POINT_OF_SALE_APP)
public interface GlobalCurrencyGroupRepository {

	@RequestMapping(value = "/api/global/categorygroup/", method = RequestMethod.GET)
	public List<UIGlobalCurrencyGroup> findAll() ;

}
