package com.brijframework.production.cust.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustProductionApp;

@Repository
@Transactional
public interface CustProductionAppRepository  extends JpaRepository<EOCustProductionApp, Long>{

	Optional<EOCustProductionApp> findByCustIdAndAppid(long l, long m);

}
