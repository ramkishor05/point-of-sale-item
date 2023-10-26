package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustUnitItem;

@Repository
@Transactional
public interface CustUnitItemRepository extends JpaRepository<EOCustUnitItem, Long>{

	@Query(nativeQuery = true, value = "select * from EOCUST_UNIT_ITEM where CUST_BUSINESS_APP_ID= ?1 and DISPLAY_NAME=?2")
	Optional<EOCustUnitItem> findByCustAppAndName(Long id, String name);
	
	@Query(nativeQuery = true, value = "select * from EOCUST_UNIT_ITEM where CUST_BUSINESS_APP_ID= ?1")
	List<EOCustUnitItem> findByCustAppId(Long id);


}
