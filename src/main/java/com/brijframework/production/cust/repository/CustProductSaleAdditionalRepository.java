package com.brijframework.production.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.sales.EOCustProductSaleAdditional;

@Repository
@Transactional
public interface CustProductSaleAdditionalRepository extends JpaRepository<EOCustProductSaleAdditional, Long>{
	
}
