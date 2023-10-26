package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustCurrencyGroup;
import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCurrencyGroupGlobalCurrencyGroupMapper  extends GenericMapper<EOCustCurrencyGroup, EOGlobalCurrencyGroup>{

	@Override
	EOCustCurrencyGroup mapToDAO(EOGlobalCurrencyGroup eoGlobalCurrency);
	
	@Override
	EOGlobalCurrencyGroup mapToDTO(EOCustCurrencyGroup eoCustCurrency);
}
