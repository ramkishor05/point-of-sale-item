package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.EOCustProductRetailSale;
import com.brijframework.production.cust.entities.EOCustProductSale;
import com.brijframework.production.cust.entities.EOCustProductWholeSale;
import com.brijframework.production.cust.rest.CustProductRetailSaleResponse;
import com.brijframework.production.cust.rest.CustProductSaleResponse;
import com.brijframework.production.cust.rest.CustProductWholeSaleResponse;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductSaleResponseMapper  extends GenericMapper<EOCustProductSale, CustProductSaleResponse>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleResponse uiProduct);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Override
	CustProductSaleResponse mapToDTO(EOCustProductSale eoInvProduct);
	
	CustProductRetailSaleResponse mapToDTO(EOCustProductRetailSale eoCustProductRetailSale);
	
	EOCustProductRetailSale mapToDAO(CustProductRetailSaleResponse custProductRetailSaleResponse);
	
	CustProductWholeSaleResponse mapToDTO(EOCustProductWholeSale eoCustProductWholeSale);
	
	EOCustProductWholeSale mapToDAO(CustProductWholeSaleResponse custProductWholeSaleResponse);
	
}
