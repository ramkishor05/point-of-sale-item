package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustCurrencyGroup;

@Repository
@Transactional
public interface CustCurrencyGroupRepository extends JpaRepository<EOCustCurrencyGroup, Long>{
	
	EOCustCurrencyGroup findOneByTypeId(String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_GROUP where CUST_BUSINESS_APP_ID= ?1 and NAME=?2")
	Optional<EOCustCurrencyGroup> findByCustAppAndName(Long id, String name);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_GROUP where CUST_BUSINESS_APP_ID= ?1")
	List<EOCustCurrencyGroup> findAllByCustAppId(long custAppId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_GROUP where CUST_BUSINESS_APP_ID= ?1 and ID=?2")
	EOCustCurrencyGroup findOneByIdAndCustAppId(long custAppId, Long id);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_GROUP where CUST_BUSINESS_APP_ID= ?1 and RECORD_STATUS in(?2)")
	List<EOCustCurrencyGroup> findAllByCustAppIdAndStatusIn(long custAppId, List<String> statusIds);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_GROUP where CUST_BUSINESS_APP_ID= ?1 and TYPE_ID = ?2")
	List<EOCustCurrencyGroup>  findOneByCustAppIdAndTypeId(long custAppId, String typeId);

}
