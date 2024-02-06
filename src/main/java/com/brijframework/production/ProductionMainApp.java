package com.brijframework.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.brijframework.production.global.repository")
@SpringBootApplication
@EnableDiscoveryClient
public class ProductionMainApp 
{
	public static void main( String[] args ){
		
    	SpringApplication.run(ProductionMainApp.class, args);
    }
	
	
}
