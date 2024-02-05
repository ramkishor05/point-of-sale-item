package com.brijframework.production;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.production.cust.entities.EOCustBusinessApp;
import com.brijframework.production.cust.repository.CustBusinessAppRepository;
import com.brijframework.production.cust.service.CustBusinessAppService;

@Component
public class ProductionMainListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Value(value="${spring.database.config.data}")
	private boolean default_data;
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustBusinessAppService custBusinessAppService;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(default_data) {
    		
	    	List<EOCustBusinessApp> custBusinessApps = custBusinessAppRepository.findAll();
	    	for(EOCustBusinessApp eoCustBusinessApp :  custBusinessApps) {
	    		custBusinessAppService.init(eoCustBusinessApp);
	    	}
	    }
    }
}