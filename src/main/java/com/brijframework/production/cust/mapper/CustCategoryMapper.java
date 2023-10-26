package com.brijframework.production.cust.mapper;
import static com.brijframework.production.contants.Constants.*;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.dto.UICustCategory;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCategoryMapper  extends GenericMapper<EOCustCategoryItem, UICustCategory>{
	

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Mapping(target=CUST_IMG_DETAIL_ID_ENTITY, source=CUST_IMG_DETAIL_ID_UI)
	@Mapping(target=CUST_GROUP_ID_ENTITY, source=CUST_GROUP_ID_UI)
	@Override
	EOCustCategoryItem mapToDAO(UICustCategory uiCategory);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Mapping(source=CUST_IMG_DETAIL_ID_ENTITY, target=CUST_IMG_DETAIL_ID_UI)
	@Mapping(source=CUST_GROUP_ID_ENTITY, target=CUST_GROUP_ID_UI)
	@Override
	UICustCategory mapToDTO(EOCustCategoryItem eoCustCategory);
}
