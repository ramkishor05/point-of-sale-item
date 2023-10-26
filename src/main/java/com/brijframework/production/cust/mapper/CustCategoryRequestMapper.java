package com.brijframework.production.cust.mapper;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.cust.rest.CustCategoryRequest;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCategoryRequestMapper  extends GenericMapper<EOCustCategoryItem, CustCategoryRequest>{

	@Override
	@Mapping(target = "custImageDetail.id", source = "custImageDetailId")
	@Mapping(target = "custCategoryGroup.id", source = "custCategoryGroupId")
	EOCustCategoryItem mapToDAO(CustCategoryRequest custCategoryRequest);
	
	@Override
	@Mapping(source = "custImageDetail.id", target = "custImageDetailId")
	@Mapping(source = "custCategoryGroup.id", target = "custCategoryGroupId")
	CustCategoryRequest mapToDTO(EOCustCategoryItem eoCustCategory);
}
