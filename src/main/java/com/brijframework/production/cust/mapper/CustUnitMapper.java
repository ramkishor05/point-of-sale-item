package com.brijframework.production.cust.mapper;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.dto.UICustUnit;
import com.brijframework.production.cust.entities.EOCustUnitItem;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustUnitMapper  extends GenericMapper<EOCustUnitItem, UICustUnit>{
	

	@Override
	EOCustUnitItem mapToDAO(UICustUnit uiCustUnit);
	
	@Override
	UICustUnit mapToDTO(EOCustUnitItem eoCustUnit);
}
