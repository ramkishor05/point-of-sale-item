package com.brijframework.production.mapper;

import java.util.Date;
import java.util.List;

import com.brijframework.production.util.CommanUtil;

public interface GenericMapper<E, D> {

	D mapToDTO(E eoRole);

	E mapToDAO(D eoRoleDTO);
	
	List<E> mapToDAO(List<D> findAll);
	
	List<D> mapToDTO(List<E> eoRoleDTO);
	

	public default Date toDate(String toStringDate) {
		return CommanUtil.toDate(toStringDate);
	}

	public default String toDate(Date toDate) {
		return CommanUtil.toDate(toDate);
	}
}
