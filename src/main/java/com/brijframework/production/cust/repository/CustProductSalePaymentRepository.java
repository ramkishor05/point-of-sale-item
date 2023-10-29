package com.brijframework.production.cust.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.sales.EOCustProductSalePayment;

@Repository
@Transactional
public interface CustProductSalePaymentRepository extends JpaRepository<EOCustProductSalePayment, Long>{

}
