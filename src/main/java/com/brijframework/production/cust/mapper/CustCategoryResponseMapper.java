package com.brijframework.production.cust.mapper;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.cust.rest.CustCategoryResponse;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCategoryResponseMapper  extends GenericMapper<EOCustCategoryItem, CustCategoryResponse>{

	@Override
	EOCustCategoryItem mapToDAO(CustCategoryResponse uiCustCategory);
	
	@Override
	CustCategoryResponse mapToDTO(EOCustCategoryItem eoCustCategory);
}
