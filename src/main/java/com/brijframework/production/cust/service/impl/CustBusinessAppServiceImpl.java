package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustBusinessApp;
import com.brijframework.production.cust.dto.UICustBusinessAppDetail;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.cust.entities.EOCustCountFreq;
import com.brijframework.production.cust.entities.EOCustCurrencyGroup;
import com.brijframework.production.cust.entities.EOCustCurrencyItem;
import com.brijframework.production.cust.entities.EOCustUnitGroup;
import com.brijframework.production.cust.entities.EOCustUnitItem;
import com.brijframework.production.cust.mapper.CustBusinessAppDetailMapper;
import com.brijframework.production.cust.mapper.CustBusinessAppMapper;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustCategoryGroupRepository;
import com.brijframework.production.cust.repository.CustCategoryItemRepository;
import com.brijframework.production.cust.repository.CustCountFreqRepository;
import com.brijframework.production.cust.repository.CustCurrencyGroupRepository;
import com.brijframework.production.cust.repository.CustCurrencyItemRepository;
import com.brijframework.production.cust.repository.CustUnitGroupRepository;
import com.brijframework.production.cust.repository.CustUnitItemRepository;
import com.brijframework.production.cust.service.CustBusinessAppService;
import com.brijframework.production.global.entities.EOGlobalCategory;
import com.brijframework.production.global.entities.EOGlobalCategoryGroup;
import com.brijframework.production.global.entities.EOGlobalCountFreq;
import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;
import com.brijframework.production.global.entities.EOGlobalCurrencyItem;
import com.brijframework.production.global.entities.EOGlobalUnit;
import com.brijframework.production.global.entities.EOGlobalUnitGroup;
import com.brijframework.production.global.repository.GlobalCategoryGroupRepository;
import com.brijframework.production.global.repository.GlobalCategoryRepository;
import com.brijframework.production.global.repository.GlobalCountFreqRepository;
import com.brijframework.production.global.repository.GlobalCurrencyGroupRepository;
import com.brijframework.production.global.repository.GlobalCurrencyItemRepository;
import com.brijframework.production.global.repository.GlobalUnitGroupRepository;
import com.brijframework.production.global.repository.GlobalUnitRepository;
import com.brijframework.production.mapper.e2e.CustCategoryGlobalCategoryMapper;
import com.brijframework.production.mapper.e2e.CustCategoryGroupGlobalCategoryGroupMapper;
import com.brijframework.production.mapper.e2e.CustCountFreqGlobalCountFreqMapper;
import com.brijframework.production.mapper.e2e.CustCurrencyGroupGlobalCurrencyGroupMapper;
import com.brijframework.production.mapper.e2e.CustCurrencyItemGlobalCurrencyItemMapper;
import com.brijframework.production.mapper.e2e.CustUnitGlobalUnitMapper;
import com.brijframework.production.mapper.e2e.CustUnitGroupGlobalUnitGroupMapper;

@Service
public class CustBusinessAppServiceImpl implements CustBusinessAppService {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustBusinessAppMapper  custBusinessAppMapper;
	
	@Autowired
	private CustBusinessAppDetailMapper custBusinessAppDetailMapper;

	@Autowired
	private GlobalCurrencyItemRepository globalCurrencyItemRepository;

	@Autowired
	private CustCurrencyItemRepository custCurrencyItemRepository;

	@Autowired
	private CustCurrencyItemGlobalCurrencyItemMapper currencyItemGlobalCurrencyItemMapper;

	@Autowired
	private GlobalCountFreqRepository globalCountFreqRepository;

	@Autowired
	private CustCountFreqRepository custCountFreqRepository;

	@Autowired
	private CustCountFreqGlobalCountFreqMapper countFreqGlobalCountFreqMapper;

	@Autowired
	private GlobalUnitGroupRepository globalUnitGroupRepository;

	@Autowired
	private CustUnitGroupRepository custUnitGroupRepository;

	@Autowired
	private CustUnitGroupGlobalUnitGroupMapper custUnitGroupGlobalUnitGroupMapper;

	@Autowired
	private GlobalUnitRepository globalUnitRepository;

	@Autowired
	private CustUnitItemRepository custUnitItemRepository;

	@Autowired
	private CustUnitGlobalUnitMapper custUnitGlobalUnitMapper;

	@Autowired
	private GlobalCategoryGroupRepository globalCategoryGroupRepository;

	@Autowired
	private CustCategoryGroupRepository custCategoryGroupRepository;

	@Autowired
	private CustCategoryGroupGlobalCategoryGroupMapper custCategoryGroupGlobalCategoryGroupMapper;

	@Autowired
	private GlobalCategoryRepository globalCategoryRepository;

	@Autowired
	private CustCategoryItemRepository custCategoryRepository;

	@Autowired
	private CustCategoryGlobalCategoryMapper custCategoryGlobalCategoryMapper;

	@Autowired
	private GlobalCurrencyGroupRepository globalCurrencyGroupRepository;

	@Autowired
	private CustCurrencyGroupRepository custCurrencyGroupRepository;

	@Autowired
	private CustCurrencyGroupGlobalCurrencyGroupMapper currencyGroupGlobalCurrencyGroupMapper;
	
	public void init(EOCustBusinessApp eoCustBusinessApp) {
		new Thread(()->{
		
	    	List<EOGlobalCurrencyGroup> eoGlobalCurrencyGroups = globalCurrencyGroupRepository.findAll();
	
			for(EOGlobalCurrencyGroup eoGlobalCurrencyGroup :  eoGlobalCurrencyGroups) {
	    		Optional<EOCustCurrencyGroup> findCustCurrencyGroup = custCurrencyGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCurrencyGroup.getName());
	    		if(!findCustCurrencyGroup.isPresent()) {
	    			EOCustCurrencyGroup eoCustCurrencyGroup = currencyGroupGlobalCurrencyGroupMapper.mapToDAO(eoGlobalCurrencyGroup);
	    			eoCustCurrencyGroup.setCustBusinessApp(eoCustBusinessApp);
	    			custCurrencyGroupRepository.saveAndFlush(eoCustCurrencyGroup);
	    		}
	    	}
			List<EOGlobalCurrencyItem> eoGlobalCurrencyItems = globalCurrencyItemRepository.findAll();
			for(EOGlobalCurrencyItem eoGlobalCurrencyItem :  eoGlobalCurrencyItems) {
	    		Optional<EOCustCurrencyItem> findCustCurrencyItem = custCurrencyItemRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCurrencyItem.getName());
	    		if(!findCustCurrencyItem.isPresent()) {
	    			EOCustCurrencyItem eoCustCurrencyItem = currencyItemGlobalCurrencyItemMapper.mapToDAO(eoGlobalCurrencyItem);
	    			eoCustCurrencyItem.setCustBusinessApp(eoCustBusinessApp);
	    			custCurrencyItemRepository.saveAndFlush(eoCustCurrencyItem);
	    		}
	    	}
	    	List<EOGlobalCountFreq> eoGlobalCountFreqs = globalCountFreqRepository.findAll();
	    	for(EOGlobalCountFreq eoGlobalCountFreq :  eoGlobalCountFreqs) {
	    		Optional<EOCustCountFreq> findCustCountFreq = custCountFreqRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCountFreq.getName());
	    		if(!findCustCountFreq.isPresent()) {
	    			EOCustCountFreq eoCustCountFreq = countFreqGlobalCountFreqMapper.mapToDAO(eoGlobalCountFreq);
	    			eoCustCountFreq.setCustBusinessApp(eoCustBusinessApp);
	    			custCountFreqRepository.saveAndFlush(eoCustCountFreq);
	    		}
	    	}
	    	
	    	List<EOGlobalUnitGroup> eoGlobalUnitGroups = globalUnitGroupRepository.findAll();
	    	for(EOGlobalUnitGroup eoGlobalUnitGroup :  eoGlobalUnitGroups) {
	    		Optional<EOCustUnitGroup> findCustUnitGroup = custUnitGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalUnitGroup.getName());
	    		if(!findCustUnitGroup.isPresent()) {
	    			EOCustUnitGroup eoCustUnitGroup = custUnitGroupGlobalUnitGroupMapper.mapToDAO(eoGlobalUnitGroup);
	    			eoCustUnitGroup.setCustBusinessApp(eoCustBusinessApp);
	    			custUnitGroupRepository.saveAndFlush(eoCustUnitGroup);
	    		}
	    	}
	    	
	    	List<EOGlobalUnit> eoGlobalUnits = globalUnitRepository.findAll();
	    	for(EOGlobalUnit eoGlobalUnit :  eoGlobalUnits) {
	    		Optional<EOCustUnitItem> findCustUnit = custUnitItemRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalUnit.getName());
	    		if(!findCustUnit.isPresent()) {
	    			EOCustUnitItem eoCustUnit = custUnitGlobalUnitMapper.mapToDAO(eoGlobalUnit);
	    			eoCustUnit.setCustBusinessApp(eoCustBusinessApp);
	    			custUnitItemRepository.saveAndFlush(eoCustUnit);
	    		}
	    	}
	    	
	    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroups = globalCategoryGroupRepository.findAll();
	
	    	for(EOGlobalCategoryGroup eoGlobalCategoryGroup :  eoGlobalCategoryGroups) {
	    		Optional<EOCustCategoryGroup> findCustCategoryGroup = custCategoryGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCategoryGroup.getName());
	    		if(!findCustCategoryGroup.isPresent()) {
	    			EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupGlobalCategoryGroupMapper.mapToDAO(eoGlobalCategoryGroup);
	    			eoCustCategoryGroup.setCustBusinessApp(eoCustBusinessApp);
	    			custCategoryGroupRepository.saveAndFlush(eoCustCategoryGroup);
	    		}
	    	}
	    	
	    	List<EOGlobalCategory> eoGlobalCategorys = globalCategoryRepository.findAll();
	
	    	for(EOGlobalCategory eoGlobalCategory :  eoGlobalCategorys) {
	    		Optional<EOCustCategoryItem> findCustCategory = custCategoryRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCategory.getName());
	    		if(!findCustCategory.isPresent()) {
	    			EOCustCategoryItem eoCustCategory = custCategoryGlobalCategoryMapper.mapToDAO(eoGlobalCategory);
		    		EOCustCategoryGroup custCategoryGroup = custCategoryGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCategory.getGlobalCategoryGroup().getName()).orElse(null);
		    		eoCustCategory.setCustCategoryGroup(custCategoryGroup);
	    			eoCustCategory.setCustBusinessApp(eoCustBusinessApp);
	    			custCategoryRepository.saveAndFlush(eoCustCategory);
	    		}
	    	}
    	
		}).start();
	}
	
	@Override
	public UICustBusinessApp saveCustBusinessApp(UICustBusinessApp uiCustBusinessApp) {
		EOCustBusinessApp eoCustBusinessApp=custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(uiCustBusinessApp.getCustId(), uiCustBusinessApp.getAppId(),uiCustBusinessApp.getBusinessId()).orElse(new EOCustBusinessApp());
		eoCustBusinessApp.setAppId(uiCustBusinessApp.getAppId());
		eoCustBusinessApp.setCustId(uiCustBusinessApp.getCustId());
		eoCustBusinessApp.setBusinessId(uiCustBusinessApp.getBusinessId());
		eoCustBusinessApp=custBusinessAppRepository.save(eoCustBusinessApp);
		init(eoCustBusinessApp);
		return custBusinessAppMapper.mapToDTO(eoCustBusinessApp);
	}

	@Override
	public UICustBusinessApp getCustBusinessApp(long id) {
		return custBusinessAppMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );
	}

	@Override
	public boolean deleteCustBusinessApp(long id) {
		return false;
	}

	@Override
	public List<UICustBusinessApp> getCustBusinessAppList() {
		return null;
	}

	@Override
	public UICustBusinessAppDetail getCustBusinessAppDetail(long id) {
		return custBusinessAppDetailMapper.mapToDTO( custBusinessAppRepository.findById(id).orElseThrow(()-> new RuntimeException("Not fond")) );

	}
}
