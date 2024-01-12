package com.brijframework.production.cust.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.cust.entities.EOCustAccount;

@Repository
@Transactional
public interface CustAccountRepository extends JpaRepository<EOCustAccount, Long>{
	
	@Query(nativeQuery = true, value = "select * from EOCUST_TRANSACTION where CUST_BUSINESS_APP_ID=?1")
	Optional<List<EOCustAccount>> findAllByCustAppAndUserId(Long custAppId);

	@Query(nativeQuery = true, value = "select * from EOCUST_TRANSACTION where CUST_BUSINESS_APP_ID=?1 and OPENING_DATE >=?2 and CLOSING_DATE<=?3")
	Optional<List<EOCustAccount>> findAllByCustAppAndUserId(Long custAppId, String startDate, String endDate);

}
