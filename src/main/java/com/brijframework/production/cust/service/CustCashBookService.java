package com.brijframework.production.cust.service;

import java.util.List;

import com.brijframework.production.cust.rest.CustCashBookRequest;
import com.brijframework.production.cust.rest.CustCashBookResponse;

public interface CustCashBookService {

	CustCashBookResponse saveCashBook(Long custAppId, CustCashBookRequest custCashBookRequest);

	List<CustCashBookResponse> getCashBookList(Long custAppId, Long userId);

	CustCashBookResponse getCashBook(Long custAppId, Long id);

	boolean deleteCashBook(Long custAppId, Long id);

}
