package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustCountFreq;

@Repository
@Transactional
public interface CustCountFreqRepository extends JpaRepository<EOCustCountFreq, Long>{

	@Query(nativeQuery = true, value = "select * from EOCUST_COUNT_FREQ where CUST_BUSINESS_APP_ID= ?1 and NAME=?2")
	Optional<EOCustCountFreq> findByCustAppAndName(Long id, String name);

	@Query(nativeQuery = true, value = "select * from EOCUST_COUNT_FREQ where CUST_BUSINESS_APP_ID= ?1")
	List<EOCustCountFreq> findAllByCustAppId(long custAppId);
	
	@Query(nativeQuery = true, value = "select * from EOCUST_COUNT_FREQ where CUST_BUSINESS_APP_ID= ?1 and TYPE_ID=?2")
	List<EOCustCountFreq> findAllByCustAppIdAndTypeId(long custAppId, String typeId);

}
