package com.brijframework.production.global.service;

import java.util.List;

import com.brijframework.production.global.rest.GlobalCountFreqRequest;
import com.brijframework.production.global.rest.GlobalCountFreqResponse;

public interface GlobalCountFreqService {

	GlobalCountFreqResponse saveCountFreq(GlobalCountFreqRequest globalCountFreqRequest);

	GlobalCountFreqResponse getCountFreq(long id);

	List<GlobalCountFreqResponse> getCountFreqList();

	boolean deleteCountFreq(Long id);

}
