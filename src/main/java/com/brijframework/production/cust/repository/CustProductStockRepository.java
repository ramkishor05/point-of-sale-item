package com.brijframework.production.cust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustProductStock;
import static com.brijframework.production.contants.Constants.*;

@Repository
@Transactional
public interface CustProductStockRepository extends JpaRepository<EOCustProductStock, Long>{
	
	List<EOCustProductStock> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustProductStock findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);

	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " WHERE CPS.CUST_PRODUCT_PURCHASE_ID=?1 ORDER BY CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductPurchaseItemId(Long id);
	
	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " INNER JOIN "+EOCUST_PRODUCT+" CP ON CPS.CUST_PRODUCT_ID=CP.ID "
			+ " WHERE CPS.CUST_PRODUCT_PURCHASE_ID IS NULL AND CP.ID=?1 ORDER BY CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductIdOfPurchase(Long id);

	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " WHERE CPS.CUST_PRODUCT_SALE_ID=?1 ORDER BY CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductSaleItemId(Long id);
	
	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " INNER JOIN "+EOCUST_PRODUCT+" CP ON CPS.CUST_PRODUCT_ID=CP.ID "
			+ " WHERE CPS.CUST_PRODUCT_SALE_ID IS NULL AND CP.ID=?1 ORDER BY CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductIdOfSale(Long id);

}
