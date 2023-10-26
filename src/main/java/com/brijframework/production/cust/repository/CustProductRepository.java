package com.brijframework.production.cust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustProduct;

@Repository
@Transactional
public interface CustProductRepository extends JpaRepository<EOCustProduct, Long>{
	
	List<EOCustProduct> findAllByCustBusinessAppId(long custBusinessAppId);

	EOCustProduct findByCustBusinessAppIdAndTypeId(long custBusinessAppId, String typeId);


}
