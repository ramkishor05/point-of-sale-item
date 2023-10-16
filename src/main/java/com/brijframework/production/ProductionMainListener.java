package com.brijframework.production;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.production.contants.DataStatus;
import com.brijframework.production.cust.entities.EOCustCategory;
import com.brijframework.production.cust.entities.EOCustCategoryGroup;
import com.brijframework.production.cust.entities.EOCustCountFreq;
import com.brijframework.production.cust.entities.EOCustProductionApp;
import com.brijframework.production.cust.entities.EOCustUnit;
import com.brijframework.production.cust.entities.EOCustUnitGroup;
import com.brijframework.production.cust.repository.CustCategoryGroupRepository;
import com.brijframework.production.cust.repository.CustCategoryRepository;
import com.brijframework.production.cust.repository.CustCountFreqRepository;
import com.brijframework.production.cust.repository.CustProductionAppRepository;
import com.brijframework.production.cust.repository.CustUnitGroupRepository;
import com.brijframework.production.cust.repository.CustUnitRepository;
import com.brijframework.production.global.entities.EOGlobalCategory;
import com.brijframework.production.global.entities.EOGlobalCategoryGroup;
import com.brijframework.production.global.entities.EOGlobalCountFreq;
import com.brijframework.production.global.entities.EOGlobalUnit;
import com.brijframework.production.global.entities.EOGlobalUnitConversion;
import com.brijframework.production.global.entities.EOGlobalUnitGroup;
import com.brijframework.production.global.repository.GlobalCategoryGroupRepository;
import com.brijframework.production.global.repository.GlobalCategoryRepository;
import com.brijframework.production.global.repository.GlobalCountFreqRepository;
import com.brijframework.production.global.repository.GlobalUnitConversionRepository;
import com.brijframework.production.global.repository.GlobalUnitGroupRepository;
import com.brijframework.production.global.repository.GlobalUnitRepository;
import com.brijframework.production.mapper.e2e.CustCategoryGlobalCategoryMapper;
import com.brijframework.production.mapper.e2e.CustCategoryGroupGlobalCategoryGroupMapper;
import com.brijframework.production.mapper.e2e.CustCountFreqGlobalCountFreqMapper;
import com.brijframework.production.mapper.e2e.CustUnitGlobalUnitMapper;
import com.brijframework.production.mapper.e2e.CustUnitGroupGlobalUnitGroupMapper;
import com.brijframework.production.schema.factories.JsonSchemaDataFactory;

@Component
public class ProductionMainListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private GlobalCountFreqRepository globalCountFreqRepository;
	
	@Autowired
	private GlobalUnitConversionRepository globalUnitConversionRepository;
	
	@Autowired
	private CustCountFreqRepository custCountFreqRepository;
	
	@Autowired
	private CustProductionAppRepository custProductionAppRepository;
	
	@Autowired
	private CustUnitGroupRepository custUnitGroupRepository;
	
	@Autowired
	private GlobalUnitGroupRepository glbUnitGroupRepository;
	
	@Autowired
	private CustUnitRepository custUnitRepository;
	
	@Autowired
	private GlobalUnitRepository glbUnitRepository;
	
	@Autowired
	private CustCategoryGroupRepository custCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryGroupRepository glbCategoryGroupRepository;
	
	@Autowired
	private CustCategoryRepository custCategoryRepository;
	
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
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	
    	JsonSchemaDataFactory instance = JsonSchemaDataFactory.getInstance();
    	
    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroupJson = instance.getAll(EOGlobalCategoryGroup.class);
    	
    	eoGlobalCategoryGroupJson.forEach(eoGlobalCategoryGroup->{
    		EOGlobalCategoryGroup findGlobalCategoryGroup = glbCategoryGroupRepository.findByTypeId(eoGlobalCategoryGroup.getTypeId()).orElse(eoGlobalCategoryGroup);
    		BeanUtils.copyProperties(eoGlobalCategoryGroup, findGlobalCategoryGroup);
    		findGlobalCategoryGroup.setRecordState(DataStatus.ACTIVETED.getStatus());
    		EOGlobalCategoryGroup eoGlobalCategoryGroupSave= glbCategoryGroupRepository.save(findGlobalCategoryGroup);
    		eoGlobalCategoryGroup.setId(eoGlobalCategoryGroupSave.getId());
    	});
    	List<EOGlobalCategory> eoGlobalCategoryJson = instance.getAll(EOGlobalCategory.class);
    	
    	eoGlobalCategoryJson.forEach(eoGlobalCategory->{
    		if(glbCategoryRepository.countByTypeId(eoGlobalCategory.getTypeId())==0) {
    			eoGlobalCategory.setRecordState(DataStatus.ACTIVETED.getStatus());
	    		EOGlobalCategory eoGlobalCategorySave= glbCategoryRepository.save(eoGlobalCategory);
	    		eoGlobalCategory.setId(eoGlobalCategorySave.getId());
    		}
    	});
    	
    	List<EOGlobalUnitGroup> eoGlobalUnitGroupsJson = instance.getAll(EOGlobalUnitGroup.class);
    	
    	eoGlobalUnitGroupsJson.forEach(eoGlobalUnitGroup->{
    		EOGlobalUnitGroup findGlobalUnitGroup = glbUnitGroupRepository.findByTypeId(eoGlobalUnitGroup.getTypeId()).orElse(eoGlobalUnitGroup);
    		BeanUtils.copyProperties(eoGlobalUnitGroup, findGlobalUnitGroup);
    		findGlobalUnitGroup.setRecordState(DataStatus.ACTIVETED.getStatus());
    		EOGlobalUnitGroup eoGlobalUnitGroupSave= glbUnitGroupRepository.save(findGlobalUnitGroup);
    		eoGlobalUnitGroup.setId(eoGlobalUnitGroupSave.getId());
    	});
    	

    	List<EOGlobalUnit> eoGlobalUnitsJson = instance.getAll(EOGlobalUnit.class);

    	eoGlobalUnitsJson.forEach(eoGlobalUnit->{
    		if(glbUnitRepository.countByTypeId(eoGlobalUnit.getTypeId())==0) {
    			eoGlobalUnit.setRecordState(DataStatus.ACTIVETED.getStatus());
	    		EOGlobalUnit eoGlobalUnitSave= glbUnitRepository.save(eoGlobalUnit);
	    		eoGlobalUnit.setId(eoGlobalUnitSave.getId());
    		}
    	});
    	
    	List<EOGlobalCountFreq> eoGlobalCountFreqsJson = instance.getAll(EOGlobalCountFreq.class);

    	eoGlobalCountFreqsJson.forEach(eoGlobalCountFreq->{
    		if(globalCountFreqRepository.countByTypeId(eoGlobalCountFreq.getTypeId())==0) {
    			eoGlobalCountFreq.setRecordState(DataStatus.ACTIVETED.getStatus());
	    		EOGlobalCountFreq eoGlobalCountFreqSave = globalCountFreqRepository.save(eoGlobalCountFreq);
	    		eoGlobalCountFreq.setId(eoGlobalCountFreqSave.getId());
    		}
    	});
    	
    	List<EOGlobalUnitConversion> eoGlobalUnitConversions = instance.getAll(EOGlobalUnitConversion.class);

    	eoGlobalUnitConversions.forEach(eoGlobalUnitConversion->{
    		if(globalUnitConversionRepository.countByTypeId(eoGlobalUnitConversion.getTypeId())==0) {
    			eoGlobalUnitConversion.setRecordState(DataStatus.ACTIVETED.getStatus());
	    		EOGlobalUnitConversion eoGlobalUnitConversionSave =globalUnitConversionRepository.save(eoGlobalUnitConversion);
	    		eoGlobalUnitConversion.setId(eoGlobalUnitConversionSave.getId());
    		}
    	});
    	
    	
    	Optional<EOCustProductionApp> findCustProductionApp = custProductionAppRepository.findByCustIdAndAppid(1L,1l);
    	if(!findCustProductionApp.isPresent()) {
    		EOCustProductionApp custProductionApp =new EOCustProductionApp();
    		custProductionApp.setCustId(1l);
    		custProductionApp.setAppid(1l);
    		custProductionAppRepository.saveAndFlush(custProductionApp);
    	}
    	
    	List<EOCustProductionApp> custProductionApps = custProductionAppRepository.findAll();
    	
    	/// 
    	List<EOGlobalCountFreq> eoGlobalCountFreqs = globalCountFreqRepository.findAll();
    	for(EOCustProductionApp eoCustProductionApp :  custProductionApps) {
	    	for(EOGlobalCountFreq eoGlobalCountFreq :  eoGlobalCountFreqs) {
	    		Optional<EOCustCountFreq> findCustCountFreq = custCountFreqRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalCountFreq.getName());
	    		if(!findCustCountFreq.isPresent()) {
	    			EOCustCountFreq eoCustCountFreq = countFreqGlobalCountFreqMapper.mapToDAO(eoGlobalCountFreq);
	    			eoCustCountFreq.setCustProductionApp(eoCustProductionApp);
	    			custCountFreqRepository.saveAndFlush(eoCustCountFreq);
	    		}
	    	}
    	}
    	
    	///
    	List<EOGlobalUnitGroup> eoGlobalUnitGroups = glbUnitGroupRepository.findAll();
    	for(EOCustProductionApp eoCustProductionApp :  custProductionApps) {
	    	for(EOGlobalUnitGroup eoGlobalUnitGroup :  eoGlobalUnitGroups) {
	    		Optional<EOCustUnitGroup> findCustUnitGroup = custUnitGroupRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalUnitGroup.getName());
	    		if(!findCustUnitGroup.isPresent()) {
	    			EOCustUnitGroup eoCustUnitGroup = custUnitGroupGlobalUnitGroupMapper.mapToDAO(eoGlobalUnitGroup);
	    			eoCustUnitGroup.setCustProductionApp(eoCustProductionApp);
	    			custUnitGroupRepository.saveAndFlush(eoCustUnitGroup);
	    		}
	    	}
    	}
    	
    	///
    	List<EOGlobalUnit> eoGlobalUnits = glbUnitRepository.findAll();
    	for(EOCustProductionApp eoCustProductionApp :  custProductionApps) {
	    	for(EOGlobalUnit eoGlobalUnit :  eoGlobalUnits) {
	    		Optional<EOCustUnit> findCustUnit = custUnitRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalUnit.getName());
	    		if(!findCustUnit.isPresent()) {
	    			EOCustUnit eoCustUnit = custUnitGlobalUnitMapper.mapToDAO(eoGlobalUnit);
	    			eoCustUnit.setCustProductionApp(eoCustProductionApp);
	    			custUnitRepository.saveAndFlush(eoCustUnit);
	    		}
	    	}
    	}
    	
    	///custCategoryGroupRepository
    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroups = glbCategoryGroupRepository.findAll();
    	for(EOCustProductionApp eoCustProductionApp :  custProductionApps) {
	    	for(EOGlobalCategoryGroup eoGlobalCategoryGroup :  eoGlobalCategoryGroups) {
	    		Optional<EOCustCategoryGroup> findCustCategoryGroup = custCategoryGroupRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalCategoryGroup.getName());
	    		if(!findCustCategoryGroup.isPresent()) {
	    			EOCustCategoryGroup eoCustCategoryGroup = custCategoryGroupGlobalCategoryGroupMapper.mapToDAO(eoGlobalCategoryGroup);
	    			eoCustCategoryGroup.setCustProductionApp(eoCustProductionApp);
	    			custCategoryGroupRepository.saveAndFlush(eoCustCategoryGroup);
	    		}
	    	}
    	}
    	
    	///
    	List<EOGlobalCategory> eoGlobalCategorys = glbCategoryRepository.findAll();
    	for(EOCustProductionApp eoCustProductionApp :  custProductionApps) {
	    	for(EOGlobalCategory eoGlobalCategory :  eoGlobalCategorys) {
	    		Optional<EOCustCategory> findCustCategory = custCategoryRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalCategory.getName());
	    		if(!findCustCategory.isPresent()) {
	    			EOCustCategory eoCustCategory = custCategoryGlobalCategoryMapper.mapToDAO(eoGlobalCategory);
		    		EOCustCategoryGroup custCategoryGroup = custCategoryGroupRepository.findByCustAppAndName(eoCustProductionApp.getId(), eoGlobalCategory.getGlobalCategoryGroup().getName()).orElse(null);
		    		eoCustCategory.setCustCategoryGroup(custCategoryGroup);
	    			eoCustCategory.setCustProductionApp(eoCustProductionApp);
	    			custCategoryRepository.saveAndFlush(eoCustCategory);
	    		}
	    	}
    	}
    }
}