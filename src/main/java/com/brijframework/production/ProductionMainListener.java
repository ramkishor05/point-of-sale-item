package com.brijframework.production;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustCategoryItem;
import com.brijframework.production.cust.entities.EOCustCountFreq;
import com.brijframework.production.cust.entities.EOCustCurrencyGroup;
import com.brijframework.production.cust.entities.EOCustCurrencyItem;
import com.brijframework.production.cust.entities.EOCustUnitGroup;
import com.brijframework.production.cust.entities.EOCustUnitItem;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.repository.CustCategoryGroupRepository;
import com.brijframework.production.cust.repository.CustCategoryItemRepository;
import com.brijframework.production.cust.repository.CustCountFreqRepository;
import com.brijframework.production.cust.repository.CustCurrencyGroupRepository;
import com.brijframework.production.cust.repository.CustCurrencyItemRepository;
import com.brijframework.production.cust.repository.CustUnitGroupRepository;
import com.brijframework.production.cust.repository.CustUnitItemRepository;
import com.brijframework.production.global.entities.EOGlobalCategory;
import com.brijframework.production.global.entities.EOGlobalCategoryGroup;
import com.brijframework.production.global.entities.EOGlobalCountFreq;
import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;
import com.brijframework.production.global.entities.EOGlobalCurrencyItem;
import com.brijframework.production.global.entities.EOGlobalUnit;
import com.brijframework.production.global.entities.EOGlobalUnitConversion;
import com.brijframework.production.global.entities.EOGlobalUnitGroup;
import com.brijframework.production.global.repository.GlobalCategoryGroupRepository;
import com.brijframework.production.global.repository.GlobalCategoryRepository;
import com.brijframework.production.global.repository.GlobalCountFreqRepository;
import com.brijframework.production.global.repository.GlobalCurrencyGroupRepository;
import com.brijframework.production.global.repository.GlobalCurrencyItemRepository;
import com.brijframework.production.global.repository.GlobalUnitConversionRepository;
import com.brijframework.production.global.repository.GlobalUnitGroupRepository;
import com.brijframework.production.global.repository.GlobalUnitRepository;
import com.brijframework.production.mapper.e2e.CustCategoryGlobalCategoryMapper;
import com.brijframework.production.mapper.e2e.CustCategoryGroupGlobalCategoryGroupMapper;
import com.brijframework.production.mapper.e2e.CustCountFreqGlobalCountFreqMapper;
import com.brijframework.production.mapper.e2e.CustCurrencyGroupGlobalCurrencyGroupMapper;
import com.brijframework.production.mapper.e2e.CustCurrencyItemGlobalCurrencyItemMapper;
import com.brijframework.production.mapper.e2e.CustUnitGlobalUnitMapper;
import com.brijframework.production.mapper.e2e.CustUnitGroupGlobalUnitGroupMapper;
import com.brijframework.production.schema.factories.JsonSchemaDataFactory;

@Component
public class ProductionMainListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Value(value="${spring.database.config.data}")
	private boolean default_data;
	
	@Autowired
	private GlobalCurrencyGroupRepository globalCurrencyGroupRepository;
	
	@Autowired
	private GlobalCurrencyItemRepository globalCurrencyItemRepository;
	
	@Autowired
	private GlobalCountFreqRepository globalCountFreqRepository;
	
	@Autowired
	private GlobalUnitConversionRepository globalUnitConversionRepository;
	
	@Autowired
	private CustCountFreqRepository custCountFreqRepository;
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustUnitGroupRepository custUnitGroupRepository;
	
	@Autowired
	private GlobalUnitGroupRepository glbUnitGroupRepository;
	
	@Autowired
	private CustUnitItemRepository custUnitRepository;
	
	@Autowired
	private GlobalUnitRepository glbUnitRepository;
	
	@Autowired
	private CustCategoryGroupRepository custCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryGroupRepository glbCategoryGroupRepository;
	
	@Autowired
	private CustCategoryItemRepository custCategoryRepository;
	
	@Autowired
	private GlobalCategoryRepository glbCategoryRepository;
	

	@Autowired
	private CustCountFreqGlobalCountFreqMapper countFreqGlobalCountFreqMapper;
	
	@Autowired
	private CustUnitGlobalUnitMapper custUnitGlobalUnitMapper;
	
	@Autowired
	private CustUnitGroupGlobalUnitGroupMapper custUnitGroupGlobalUnitGroupMapper;
	
	@Autowired
	private CustCategoryGlobalCategoryMapper custCategoryGlobalCategoryMapper;
	
	@Autowired
	private CustCategoryGroupGlobalCategoryGroupMapper custCategoryGroupGlobalCategoryGroupMapper;

	@Autowired
	private CustCurrencyGroupGlobalCurrencyGroupMapper currencyGroupGlobalCurrencyGroupMapper;

	@Autowired
	private CustCurrencyGroupRepository custCurrencyGroupRepository;
	
	@Autowired
	private CustCurrencyItemGlobalCurrencyItemMapper currencyItemGlobalCurrencyItemMapper;

	@Autowired
	private CustCurrencyItemRepository custCurrencyItemRepository;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(default_data) {
	    	JsonSchemaDataFactory instance = JsonSchemaDataFactory.getInstance();
	    	List<EOGlobalCurrencyGroup> eoGlobalCurrencyGroupJson = instance.getAll(EOGlobalCurrencyGroup.class);
	    	eoGlobalCurrencyGroupJson.forEach(eoGlobalCurrencyGroup->{
	    		EOGlobalCurrencyGroup findGlobalCurrencyGroup = globalCurrencyGroupRepository.findByTypeId(eoGlobalCurrencyGroup.getTypeId()).orElse(eoGlobalCurrencyGroup);
	    		BeanUtils.copyProperties(eoGlobalCurrencyGroup, findGlobalCurrencyGroup,"id");
	    		findGlobalCurrencyGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCurrencyGroup eoGlobalCurrencyGroupSave= globalCurrencyGroupRepository.save(findGlobalCurrencyGroup);
	    		eoGlobalCurrencyGroup.setId(eoGlobalCurrencyGroupSave.getId());
	    	});
	    	
	    	List<EOGlobalCurrencyItem> eoGlobalCurrencyItemJson = instance.getAll(EOGlobalCurrencyItem.class);
	    	eoGlobalCurrencyItemJson.forEach(eoGlobalCurrencyItem->{
	    		if(globalCurrencyItemRepository.countByTypeId(eoGlobalCurrencyItem.getTypeId())==0) {
	    			eoGlobalCurrencyItem.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalCurrencyItem eoGlobalCurrencyItemSave= globalCurrencyItemRepository.save(eoGlobalCurrencyItem);
		    		eoGlobalCurrencyItem.setId(eoGlobalCurrencyItemSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroupJson = instance.getAll(EOGlobalCategoryGroup.class);
	    	
	    	eoGlobalCategoryGroupJson.forEach(eoGlobalCategoryGroup->{
	    		EOGlobalCategoryGroup findGlobalCategoryGroup = glbCategoryGroupRepository.findByTypeId(eoGlobalCategoryGroup.getTypeId()).orElse(eoGlobalCategoryGroup);
	    		BeanUtils.copyProperties(eoGlobalCategoryGroup, findGlobalCategoryGroup,"id");
	    		findGlobalCategoryGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCategoryGroup eoGlobalCategoryGroupSave= glbCategoryGroupRepository.save(findGlobalCategoryGroup);
	    		eoGlobalCategoryGroup.setId(eoGlobalCategoryGroupSave.getId());
	    	});
	    	
	    	List<EOGlobalCategory> eoGlobalCategoryJson = instance.getAll(EOGlobalCategory.class);
	    	
	    	eoGlobalCategoryJson.forEach(eoGlobalCategory->{
	    		if(glbCategoryRepository.countByTypeId(eoGlobalCategory.getTypeId())==0) {
	    			eoGlobalCategory.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalCategory eoGlobalCategorySave= glbCategoryRepository.save(eoGlobalCategory);
		    		eoGlobalCategory.setId(eoGlobalCategorySave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalUnitGroup> eoGlobalUnitGroupsJson = instance.getAll(EOGlobalUnitGroup.class);
	    	
	    	eoGlobalUnitGroupsJson.forEach(eoGlobalUnitGroup->{
	    		EOGlobalUnitGroup findGlobalUnitGroup = glbUnitGroupRepository.findByTypeId(eoGlobalUnitGroup.getTypeId()).orElse(eoGlobalUnitGroup);
	    		BeanUtils.copyProperties(eoGlobalUnitGroup, findGlobalUnitGroup,"id");
	    		findGlobalUnitGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalUnitGroup eoGlobalUnitGroupSave= glbUnitGroupRepository.save(findGlobalUnitGroup);
	    		eoGlobalUnitGroup.setId(eoGlobalUnitGroupSave.getId());
	    	});
	    	
	
	    	List<EOGlobalUnit> eoGlobalUnitsJson = instance.getAll(EOGlobalUnit.class);
	
	    	eoGlobalUnitsJson.forEach(eoGlobalUnit->{
	    		if(glbUnitRepository.countByTypeId(eoGlobalUnit.getTypeId())==0) {
	    			eoGlobalUnit.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalUnit eoGlobalUnitSave= glbUnitRepository.save(eoGlobalUnit);
		    		eoGlobalUnit.setId(eoGlobalUnitSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalCountFreq> eoGlobalCountFreqsJson = instance.getAll(EOGlobalCountFreq.class);
	
	    	eoGlobalCountFreqsJson.forEach(eoGlobalCountFreq->{
	    		if(globalCountFreqRepository.countByTypeId(eoGlobalCountFreq.getTypeId())==0) {
	    			eoGlobalCountFreq.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalCountFreq eoGlobalCountFreqSave = globalCountFreqRepository.save(eoGlobalCountFreq);
		    		eoGlobalCountFreq.setId(eoGlobalCountFreqSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalUnitConversion> eoGlobalUnitConversions = instance.getAll(EOGlobalUnitConversion.class);
	
	    	eoGlobalUnitConversions.forEach(eoGlobalUnitConversion->{
	    		if(globalUnitConversionRepository.countByTypeId(eoGlobalUnitConversion.getTypeId())==0) {
	    			eoGlobalUnitConversion.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalUnitConversion eoGlobalUnitConversionSave =globalUnitConversionRepository.save(eoGlobalUnitConversion);
		    		eoGlobalUnitConversion.setId(eoGlobalUnitConversionSave.getId());
	    		}
	    	});
	    	
	    	
	    	Optional<EOCustBusinessApp> findCustBusinessApp = custBusinessAppRepository.findByCustIdAndAppid(1L,1l);
	    	if(!findCustBusinessApp.isPresent()) {
	    		EOCustBusinessApp custBusinessApp =new EOCustBusinessApp();
	    		custBusinessApp.setCustId(1l);
	    		custBusinessApp.setAppid(1l);
	    		custBusinessAppRepository.saveAndFlush(custBusinessApp);
	    	}
	    	
	    	List<EOCustBusinessApp> custBusinessApps = custBusinessAppRepository.findAll();
	    	
	    	/// 
	    	List<EOGlobalCurrencyGroup> eoGlobalCurrencyGroups = globalCurrencyGroupRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalCurrencyGroup eoGlobalCurrencyGroup :  eoGlobalCurrencyGroups) {
		    		Optional<EOCustCurrencyGroup> findCustCurrencyGroup = custCurrencyGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCurrencyGroup.getName());
		    		if(!findCustCurrencyGroup.isPresent()) {
		    			EOCustCurrencyGroup eoCustCurrencyGroup = currencyGroupGlobalCurrencyGroupMapper.mapToDAO(eoGlobalCurrencyGroup);
		    			eoCustCurrencyGroup.setCustBusinessApp(eoCustBusinessApp);
		    			custCurrencyGroupRepository.saveAndFlush(eoCustCurrencyGroup);
		    		}
		    	}
	    	}
	    	
	    	/// 
	    	List<EOGlobalCurrencyItem> eoGlobalCurrencyItems = globalCurrencyItemRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalCurrencyItem eoGlobalCurrencyItem :  eoGlobalCurrencyItems) {
		    		Optional<EOCustCurrencyItem> findCustCurrencyItem = custCurrencyItemRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCurrencyItem.getName());
		    		if(!findCustCurrencyItem.isPresent()) {
		    			EOCustCurrencyItem eoCustCurrencyItem = currencyItemGlobalCurrencyItemMapper.mapToDAO(eoGlobalCurrencyItem);
		    			eoCustCurrencyItem.setCustBusinessApp(eoCustBusinessApp);
		    			custCurrencyItemRepository.saveAndFlush(eoCustCurrencyItem);
		    		}
		    	}
	    	}
	    	
	    	/// 
	    	List<EOGlobalCountFreq> eoGlobalCountFreqs = globalCountFreqRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalCountFreq eoGlobalCountFreq :  eoGlobalCountFreqs) {
		    		Optional<EOCustCountFreq> findCustCountFreq = custCountFreqRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCountFreq.getName());
		    		if(!findCustCountFreq.isPresent()) {
		    			EOCustCountFreq eoCustCountFreq = countFreqGlobalCountFreqMapper.mapToDAO(eoGlobalCountFreq);
		    			eoCustCountFreq.setCustBusinessApp(eoCustBusinessApp);
		    			custCountFreqRepository.saveAndFlush(eoCustCountFreq);
		    		}
		    	}
	    	}
	    	
	    	///
	    	List<EOGlobalUnitGroup> eoGlobalUnitGroups = glbUnitGroupRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalUnitGroup eoGlobalUnitGroup :  eoGlobalUnitGroups) {
		    		Optional<EOCustUnitGroup> findCustUnitGroup = custUnitGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalUnitGroup.getName());
		    		if(!findCustUnitGroup.isPresent()) {
		    			EOCustUnitGroup eoCustUnitGroup = custUnitGroupGlobalUnitGroupMapper.mapToDAO(eoGlobalUnitGroup);
		    			eoCustUnitGroup.setCustBusinessApp(eoCustBusinessApp);
		    			custUnitGroupRepository.saveAndFlush(eoCustUnitGroup);
		    		}
		    	}
	    	}
	    	
	    	///
	    	List<EOGlobalUnit> eoGlobalUnits = glbUnitRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalUnit eoGlobalUnit :  eoGlobalUnits) {
		    		Optional<EOCustUnitItem> findCustUnit = custUnitRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalUnit.getName());
		    		if(!findCustUnit.isPresent()) {
		    			EOCustUnitItem eoCustUnit = custUnitGlobalUnitMapper.mapToDAO(eoGlobalUnit);
		    			eoCustUnit.setCustBusinessApp(eoCustBusinessApp);
		    			custUnitRepository.saveAndFlush(eoCustUnit);
		    		}
		    	}
	    	}
	    	
	    	///custCategoryGroupRepository
	    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroups = glbCategoryGroupRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
		    	for(EOGlobalCategoryGroup eoGlobalCategoryGroup :  eoGlobalCategoryGroups) {
		    		Optional<EOCustCategoryGroup> findCustCategoryGroup = custCategoryGroupRepository.findByCustAppAndName(eoCustBusinessApp.getId(), eoGlobalCategoryGroup.getName());
		    		if(!findCustCategoryGroup.isPresent()) {
		    			EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupGlobalCategoryGroupMapper.mapToDAO(eoGlobalCategoryGroup);
		    			eoCustCategoryGroup.setCustBusinessApp(eoCustBusinessApp);
		    			custCategoryGroupRepository.saveAndFlush(eoCustCategoryGroup);
		    		}
		    	}
	    	}
	    	
	    	///
	    	List<EOGlobalCategory> eoGlobalCategorys = glbCategoryRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
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
	    	}
	    	
	    }
    }
}