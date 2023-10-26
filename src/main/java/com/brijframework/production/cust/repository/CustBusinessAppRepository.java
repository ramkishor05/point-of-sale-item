package com.brijframework.production.cust.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustBusinessApp;

@Repository
@Transactional
public interface CustBusinessAppRepository  extends JpaRepository<EOCustBusinessApp, Long>{

	Optional<EOCustBusinessApp> findByCustIdAndAppid(long l, long m);

}
