package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_BUSINESS_ID_ENTITY;
import static com.brijframework.production.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.sales.EOCustProductSale;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;
import com.brijframework.production.cust.rest.sale.CustProductSaleItemResponse;
import com.brijframework.production.cust.rest.sale.CustProductSaleResponse;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductSaleResponseMapper  extends GenericMapper<EOCustProductSale, CustProductSaleResponse>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleResponse uiProduct);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Mapping(source=CUST_BUSINESS_ID_ENTITY, target=BUSINESS_ID_KEY)
	@Override
	CustProductSaleResponse mapToDTO(EOCustProductSale eoInvProduct);
	
	CustProductSaleItemResponse mapToDTO(EOCustProductSaleItem eoCustProductRetailSale);
	
	EOCustProductSaleItem mapToDAO(CustProductSaleItemResponse custProductRetailSaleResponse);
	
}
