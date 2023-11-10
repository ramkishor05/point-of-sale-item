package com.brijframework.production.cust.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustBusinessApp;

@Repository
@Transactional
public interface CustBusinessAppRepository  extends JpaRepository<EOCustBusinessApp, Long>{

	Optional<EOCustBusinessApp> findByCustIdAndAppId(long custId, long appId);

	Optional<EOCustBusinessApp> findByCustIdAndAppIdAndBusinessId(long custId, long appId, long businessId);

}
