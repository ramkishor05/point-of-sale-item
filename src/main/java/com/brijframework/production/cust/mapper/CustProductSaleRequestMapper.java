package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.sales.EOCustProductSale;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleAdditional;
import com.brijframework.production.cust.entities.sales.EOCustProductSaleItem;
import com.brijframework.production.cust.entities.sales.EOCustProductSalePayment;
import com.brijframework.production.cust.rest.CustProductSaleAdditional;
import com.brijframework.production.cust.rest.CustProductSaleItemRequest;
import com.brijframework.production.cust.rest.CustProductSalePayment;
import com.brijframework.production.cust.rest.CustProductSaleRequest;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductSaleRequestMapper extends GenericMapper<EOCustProductSale, CustProductSaleRequest> {


	@Mapping(target = CUST_PROD_APP_ID_ENTITY, source = CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleRequest custProductSaleRequest);

	@Mapping(source = CUST_PROD_APP_ID_ENTITY, target = CUST_PROD_APP_ID_UI)
	@Override
	CustProductSaleRequest mapToDTO(EOCustProductSale eoCustProductSale);

	EOCustProductSaleItem mapToDAO(CustProductSaleItemRequest custProductRetailSaleRequest);

	CustProductSaleItemRequest mapToDTO(EOCustProductSaleItem eoCustProductRetailSale);

	List<CustProductSaleAdditional> custProductSaleAdditionalListDTO(List<EOCustProductSaleAdditional> custProductSaleAdditionals);
	
	List<EOCustProductSaleAdditional> custProductSaleAdditionalListDAO(List<CustProductSaleAdditional> custProductSaleAdditionals);

	List<EOCustProductSalePayment> custProductSalePaymentListDAO(List<CustProductSalePayment> custProductPaymentList);

}
