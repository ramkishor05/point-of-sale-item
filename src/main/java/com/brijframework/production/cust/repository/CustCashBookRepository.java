package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustTransaction;

@Repository
@Transactional
public interface CustCashBookRepository extends JpaRepository<EOCustTransaction, Long>{
	
	@Query(nativeQuery = true, value = "select * from EOCUST_TRANSACTION where TRANSACTION_MAKER_ID=?1")
	Optional<List<EOCustTransaction>> findAllByCustAppAndUserId(Long userId);

	@Query(nativeQuery = true, value = "select * from EOCUST_TRANSACTION where TRANSACTION_MAKER_ID=?1 and TRANSACTION_DATE between ?2 and ?3")
	Optional<List<EOCustTransaction>> findAllByCustAppAndUserId(Long userId, String startDate, String endDate);

}
