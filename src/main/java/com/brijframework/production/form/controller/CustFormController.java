package com.brijframework.production.form.controller;

import static com.brijframework.production.contants.Constants.CUST_APP_ID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.production.form.FormControl;
import com.brijframework.production.form.factories.FormControlFactory;

@RestController
@RequestMapping("/api/cust/form")
public class CustFormController {

	FormControlFactory formControlFactory=FormControlFactory.getInstance();
	
	@GetMapping("/{id}")
	public FormControl getCategoryList(@RequestHeader(CUST_APP_ID) long custAppId,@PathVariable("id") String id) {
		return formControlFactory.getCache().get(id);
	}
}
