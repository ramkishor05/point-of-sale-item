package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.purchases.EOCustProductPurchase;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseAdditional;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.production.cust.entities.purchases.EOCustProductPurchasePayment;
import com.brijframework.production.cust.rest.CustProductPurchaseAdditional;
import com.brijframework.production.cust.rest.CustProductPurchasePayment;
import com.brijframework.production.cust.rest.CustProductPurchaseRequest;
import com.brijframework.production.cust.rest.CustProductPurchaseItemRequest;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductPurchaseRequestMapper extends GenericMapper<EOCustProductPurchase, CustProductPurchaseRequest> {

	@Mapping(target = CUST_PROD_APP_ID_ENTITY, source = CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductPurchase mapToDAO(CustProductPurchaseRequest custProductPurchaseRequest);

	@Mapping(source = CUST_PROD_APP_ID_ENTITY, target = CUST_PROD_APP_ID_UI)
	@Override
	CustProductPurchaseRequest mapToDTO(EOCustProductPurchase eoCustProductPurchase);

	EOCustProductPurchaseItem mapToDAO(CustProductPurchaseItemRequest custProductRetailPurchaseRequest);

	CustProductPurchaseItemRequest mapToDTO(EOCustProductPurchaseItem eoCustProductRetailPurchase);

	List<CustProductPurchaseAdditional> custProductPurchaseAdditionalListDTO(List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionals);
	
	List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionalListDAO(List<CustProductPurchaseAdditional> custProductPurchaseAdditionals);

	List<EOCustProductPurchasePayment> custProductPurchasePaymentListDAO(List<CustProductPurchasePayment> custProductPaymentList);

}
