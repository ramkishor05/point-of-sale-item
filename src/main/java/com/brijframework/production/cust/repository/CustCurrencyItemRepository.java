package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustCurrencyItem;

@Repository
@Transactional
public interface CustCurrencyItemRepository extends JpaRepository<EOCustCurrencyItem, Long>{
	
	EOCustCurrencyItem findOneByTypeId(String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_ITEM where CUST_BUSINESS_APP_ID= ?1 and NAME=?2")
	Optional<EOCustCurrencyItem> findByCustAppAndName(Long id, String name);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_ITEM where CUST_BUSINESS_APP_ID= ?1 and TYPE_ID=?2")
	List<EOCustCurrencyItem> findAllByType(Long custAppId, String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_CURRENCY_ITEM where CUST_BUSINESS_APP_ID= ?1")
	List<EOCustCurrencyItem>  findAllByCustAppId(long custAppId);

}
