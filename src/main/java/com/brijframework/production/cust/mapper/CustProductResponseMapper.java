package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_CATEGORY_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_CATEGORY_ID_UI;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.dto.UICustProductPrice;
import com.brijframework.production.cust.entities.EOCustProduct;
import com.brijframework.production.cust.entities.EOCustProductPrice;
import com.brijframework.production.cust.rest.CustProductResponse;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductResponseMapper  extends GenericMapper<EOCustProduct, CustProductResponse>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Mapping(target=CUST_CATEGORY_ID_ENTITY, source=CUST_CATEGORY_ID_UI)
	@Override
	EOCustProduct mapToDAO(CustProductResponse uiProduct);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Mapping(source=CUST_CATEGORY_ID_ENTITY, target=CUST_CATEGORY_ID_UI)
	@Override
	CustProductResponse mapToDTO(EOCustProduct eoInvProduct);
	
	@Mapping(source="currency.id", target="currencyId")
	UICustProductPrice mapCustProductPriceDTO(EOCustProductPrice eoCustProductPrice);
	
	
	@Mapping(source="currencyId", target="currency.id")
	EOCustProductPrice mapCustProductPriceDBO(UICustProductPrice custProductPriceUi);
}
