package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.purchases.EOCustProductPurchase;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseItemResponse;
import com.brijframework.production.cust.rest.purchase.CustProductPurchaseResponse;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductPurchaseResponseMapper  extends GenericMapper<EOCustProductPurchase, CustProductPurchaseResponse>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductPurchase mapToDAO(CustProductPurchaseResponse uiProduct);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Override
	CustProductPurchaseResponse mapToDTO(EOCustProductPurchase eoInvProduct);
	
	CustProductPurchaseItemResponse mapToDTO(EOCustProductPurchaseItem eoCustProductRetailPurchase);
	
	EOCustProductPurchaseItem mapToDAO(CustProductPurchaseItemResponse custProductRetailPurchaseResponse);
	
	
}
