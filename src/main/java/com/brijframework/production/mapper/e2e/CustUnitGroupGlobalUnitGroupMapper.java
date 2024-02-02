package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustUnitGroup;
import com.brijframework.production.global.dto.UIGlobalUnitGroup;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustUnitGroupGlobalUnitGroupMapper  extends GenericMapper<EOCustUnitGroup, UIGlobalUnitGroup>{

	@Override
	EOCustUnitGroup mapToDAO(UIGlobalUnitGroup eoGlobalUnitGroup);
	
	@Override
	UIGlobalUnitGroup mapToDTO(EOCustUnitGroup eoCustUnitGroup);
}
