package com.brijframework.production.cust.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.purchases.EOCustProductPurchase;

@Repository
@Transactional
public interface CustProductPurchaseRepository extends JpaRepository<EOCustProductPurchase, Long>{
	
	List<EOCustProductPurchase> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustProductPurchase findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);

	@Query(nativeQuery = true, value = "select * from EOCUST_PRODUCT_PURCHASE where CUST_BUSINESS_APP_ID =?1 and CREATED_AT between ?2 AND ?3")
	List<EOCustProductPurchase> filterProductPurchaseList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);
	
	@Query(nativeQuery = true, value = "select * from EOCUST_PRODUCT_PURCHASE where CUST_BUSINESS_APP_ID =?1 and SUPPLIER_ID =?2 and CREATED_AT between ?3 AND ?4")
	List<EOCustProductPurchase> filterProductPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate, LocalDateTime toDate);

	@Query(nativeQuery = true, value = "select * from EOCUST_PRODUCT_PURCHASE where CUST_BUSINESS_APP_ID =?1 and SUPPLIER_ID =?2 order by CREATED_AT desc")
	List<EOCustProductPurchase> findAllByCustBusinessAppIdAndSupplierId(long custAppId, Long supplierId);
	

	@Query(nativeQuery = true, value = "select * from EOCUST_PRODUCT_PURCHASE where CUST_BUSINESS_APP_ID =?1 and USER_ID =?2 order by CREATED_AT desc")
	List<EOCustProductPurchase> findAllByCustBusinessAppIdAndUserId(long custAppId, Long userId);
}
