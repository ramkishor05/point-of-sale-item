package com.brijframework.production.global.mapper;

import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_GLB_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.production.global.dto.UIGlobalCurrencyGroup;
import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_GLB_PRODUCTION_MAPPER_IMPL)
public interface GlobalCurrencyGroupMapper extends GenericMapper<EOGlobalCurrencyGroup, UIGlobalCurrencyGroup>{

}
