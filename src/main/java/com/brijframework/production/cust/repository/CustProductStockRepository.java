package com.brijframework.production.cust.repository;

import static com.brijframework.production.contants.Constants.*;
import static com.brijframework.production.contants.Constants.EOCUST_PRODUCT_STOCK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustProductStock;

@Repository
@Transactional
public interface CustProductStockRepository extends JpaRepository<EOCustProductStock, Long>{
	
	List<EOCustProductStock> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustProductStock findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);

	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " WHERE CPS.CUST_PRODUCT_ID=?1 ORDER BY CPS.CREATED_AT DESC")
	List<EOCustProductStock> getAllByCustProductId(Long id);
	
	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " INNER JOIN "+EOCUST_PRODUCT+" CP ON CPS.CUST_PRODUCT_ID=CP.ID "
			+ " WHERE CPS.CUST_PRODUCT_PURCHASE_ID IS NULL AND CP.ID=?1 ORDER BY CPS.CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductIdOfPurchase(Long id);

	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " WHERE CPS.CUST_PRODUCT_SALE_ID=?1 ORDER BY CPS.CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductSaleItemId(Long id);
	
	@Query(nativeQuery = true, value = "Select CPS.* from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " INNER JOIN "+EOCUST_PRODUCT+" CP ON CPS.CUST_PRODUCT_ID=CP.ID "
			+ " WHERE CPS.CUST_PRODUCT_SALE_ID IS NULL AND CP.ID=?1 ORDER BY CPS.CREATED_AT DESC")
	List<EOCustProductStock> findAllByCustProductIdOfSale(Long id);
	
	interface ProductStock{
		public String getName();
		public String getProductId();
		public String getIdenNo();
		public String getStatus();
		public Double getQnt();
		public Double getSalePrice();
		public Double getPurchasePrice();
	}

	@Query(nativeQuery = true, value = "Select CP.TITLE as Name, CP.ID as ProductId, CPS.IDEN_NO as IdenNo, CPS.STOCK_STATUS as Status, 1 as Qnt,CPSPS.PRICE as SalePrice, CPSPP.PRICE AS PurchasePrice from "+EOCUST_PRODUCT_STOCK+" CPS "
			+ " INNER JOIN "+EOCUST_PRODUCT+" CP ON CPS.CUST_PRODUCT_ID=CP.ID "
			+ " INNER JOIN "+EOCUST_PRODUCT_STOCK_PRICE+" CPSPP ON CPSPP.ID=CPS.PURCHASE_PRICE "
			+ " LEFT JOIN "+EOCUST_PRODUCT_STOCK_PRICE+" CPSPS ON CPSPS.ID=CPS.SALE_PRICE "
			+ " WHERE CP.ID=?1 ORDER BY CPS.CREATED_AT DESC")
	List<ProductStock> findAllByCustProductId(Long id);
}
