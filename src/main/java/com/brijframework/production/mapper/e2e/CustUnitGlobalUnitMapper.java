package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustUnitItem;
import com.brijframework.production.global.entities.EOGlobalUnit;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustUnitGlobalUnitMapper  extends GenericMapper<EOCustUnitItem, EOGlobalUnit>{

	@Override
	EOCustUnitItem mapToDAO(EOGlobalUnit eoGlobalUnit);
	
	@Override
	EOGlobalUnit mapToDTO(EOCustUnitItem eoCustUnit);
}
