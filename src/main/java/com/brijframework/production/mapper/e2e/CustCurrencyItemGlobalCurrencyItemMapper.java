package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustCurrencyItem;
import com.brijframework.production.global.dto.UIGlobalCurrencyItem;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCurrencyItemGlobalCurrencyItemMapper  extends GenericMapper<EOCustCurrencyItem, UIGlobalCurrencyItem>{

	@Override
	EOCustCurrencyItem mapToDAO(UIGlobalCurrencyItem eoGlobalCurrency);
	
	@Override
	UIGlobalCurrencyItem mapToDTO(EOCustCurrencyItem eoCustCurrency);
}
