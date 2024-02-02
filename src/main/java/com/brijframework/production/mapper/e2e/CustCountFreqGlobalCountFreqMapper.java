package com.brijframework.production.mapper.e2e;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.cust.entities.EOCustCountFreq;
import com.brijframework.production.global.dto.UIGlobalCountFreq;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustCountFreqGlobalCountFreqMapper  extends GenericMapper<EOCustCountFreq, UIGlobalCountFreq>{

	@Override
	EOCustCountFreq mapToDAO(UIGlobalCountFreq eoGlobalCountFreq);
	
	@Override
	UIGlobalCountFreq mapToDTO(EOCustCountFreq eoCustCountFreq);
}
