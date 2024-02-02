package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.global.dto.UIGlobalCategoryGroup;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCategoryGroupGlobalCategoryGroupMapper  extends GenericMapper<EOCustCategoryGroup, UIGlobalCategoryGroup>{

	@Override
	EOCustCategoryGroup mapToDAO(UIGlobalCategoryGroup eoGlobalCategoryGroup);
	
	@Override
	UIGlobalCategoryGroup mapToDTO(EOCustCategoryGroup eoCustCategoryGroup);
}
