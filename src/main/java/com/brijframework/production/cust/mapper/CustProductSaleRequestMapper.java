package com.brijframework.production.cust.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.EOCustProductRetailSale;
import com.brijframework.production.cust.entities.EOCustProductSale;
import com.brijframework.production.cust.entities.EOCustProductWholeSale;
import com.brijframework.production.cust.rest.CustProductRetailSaleRequest;
import com.brijframework.production.cust.rest.CustProductSaleRequest;
import com.brijframework.production.cust.rest.CustProductWholeSaleRequest;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustProductSaleRequestMapper extends GenericMapper<EOCustProductSale, CustProductSaleRequest> {


	@Mapping(target = CUST_PROD_APP_ID_ENTITY, source = CUST_PROD_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleRequest custProductSaleRequest);

	@Mapping(source = CUST_PROD_APP_ID_ENTITY, target = CUST_PROD_APP_ID_UI)
	@Override
	CustProductSaleRequest mapToDTO(EOCustProductSale eoCustProductSale);

	EOCustProductRetailSale mapToDAO(CustProductRetailSaleRequest custProductRetailSaleRequest);

	CustProductRetailSaleRequest mapToDTO(EOCustProductRetailSale eoCustProductRetailSale);

	EOCustProductWholeSale mapToDAO(CustProductWholeSaleRequest custProductWholeSaleRequest);

	CustProductWholeSaleRequest mapToDTO(EOCustProductWholeSale eoCustProductWholeSale);

}
