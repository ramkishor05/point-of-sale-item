package com.brijframework.production.filters;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;
import static com.brijframework.production.contants.Constants.OWNER_ID;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.brijframework.production.cust.repository.CustBusinessAppRepository;

@Component
@Order(0)
public class TransactionFilter implements Filter {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String ownerId = req.getHeader(OWNER_ID);
        MutableHttpServletRequest requestWrapper = new MutableHttpServletRequest(req);
        System.out.println("ownerId="+ownerId);
        if(Objects.nonNull(ownerId)) {
        	custBusinessAppRepository.findByCustIdAndAppid(Long.valueOf(ownerId), 1l).ifPresent((custBusinessApp)->{
        		System.out.println("CUST_APP_ID="+custBusinessApp.getId());
        		requestWrapper.putHeader(CUST_APP_ID, ""+custBusinessApp.getId());
        		req.setAttribute(CUST_APP_ID, ""+custBusinessApp.getId());
        	});
        }
        chain.doFilter(requestWrapper, response);
    }
}