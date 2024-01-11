package com.brijframework.production.cust.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.entities.EOCustTransaction;
import com.brijframework.production.cust.mapper.CustCashBookResponseMapper;
import com.brijframework.production.cust.repository.CustCashBookRepository;
import com.brijframework.production.cust.rest.CustCashBookRequest;
import com.brijframework.production.cust.rest.CustCashBookResponse;
import com.brijframework.production.cust.service.CustCashBookService;

@Service
public class CustCashBookServiceImpl implements CustCashBookService {
	
	@Autowired
	private CustCashBookRepository custCashBookRepository;
	
	@Autowired
	private CustCashBookResponseMapper custCashBookResponseMapper;

	@Override
	public CustCashBookResponse saveCashBook(Long custAppId, CustCashBookRequest custCashBookRequest) {
		return null;
	}

	@Override
	public List<CustCashBookResponse> getCashBookList(Long custAppId, Long userId) {
		return custCashBookResponseMapper.mapToDTO(custCashBookRepository.findAllByCustAppAndUserId(userId).orElse(new ArrayList<EOCustTransaction>())) ;
	}
	
	@Override
	public List<CustCashBookResponse> getCashBookFiltedList(Long custAppId, Long userId, String startDate,
			String endDate) {
		return custCashBookResponseMapper.mapToDTO(custCashBookRepository.findAllByCustAppAndUserId(userId, startDate, endDate).orElse(new ArrayList<EOCustTransaction>())) ;
	}

	@Override
	public CustCashBookResponse getCashBook(Long custAppId, Long id) {
		return null;
	}

	@Override
	public boolean deleteCashBook(Long custAppId, Long id) {
		return false;
	}

}
