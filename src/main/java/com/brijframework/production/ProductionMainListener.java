package com.brijframework.production;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.production.contants.RecordStatus;
import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.service.CustBusinessAppService;
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
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private GlobalUnitGroupRepository glbUnitGroupRepository;
	
	@Autowired
	private GlobalUnitRepository glbUnitRepository;
	
	@Autowired
	private GlobalCategoryGroupRepository glbCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryRepository glbCategoryRepository;
	
	@Autowired
	private CustBusinessAppService custBusinessAppService;
	
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
	    	
	    	List<EOCustBusinessApp> custBusinessApps = custBusinessAppRepository.findAll();
	    	
	    	/// 
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
	    		custBusinessAppService.init(eoCustBusinessApp);
	    	}
	    	
	    }
    }
}