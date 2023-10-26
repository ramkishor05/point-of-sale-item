package com.brijframework.production.cust.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustProductSale;

@Repository
@Transactional
public interface CustProductSaleRepository extends JpaRepository<EOCustProductSale, Long>{
	
	List<EOCustProductSale> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustProductSale findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_PRODUCT_SALE where CUST_BUSINESS_APP_ID =?1 and CREATED_AT between ?2 AND ?3")
	List<EOCustProductSale> filterProductSaleList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

}
