package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.*;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.rest.CustProductRequest;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductRequestMapper  extends GenericMapper<EOCustProduct, CustProductRequest>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Mapping(target=CUST_CATEGORY_ID_ENTITY, source=CUST_CATEGORY_ID_UI)
	@Override
	EOCustProduct mapToDAO(CustProductRequest custProductRequest);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Mapping(source=CUST_CATEGORY_ID_ENTITY, target=CUST_CATEGORY_ID_UI)
	@Override
	CustProductRequest mapToDTO(EOCustProduct eoCustProduct);
	
}
