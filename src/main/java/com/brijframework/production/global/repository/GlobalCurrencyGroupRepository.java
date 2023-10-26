package com.brijframework.production.global.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.global.entities.EOGlobalCurrencyGroup;

@Repository
@Transactional
public interface GlobalCurrencyGroupRepository extends JpaRepository<EOGlobalCurrencyGroup, Long>{
	
	EOGlobalCurrencyGroup findOneByTypeId(String typeId);

	@Query(nativeQuery = true, value = "select * from EOGLOBAL_CURRENCY_GROUP where RECORD_STATUS in (?1)")
	List<EOGlobalCurrencyGroup> getCurrencyGroupListByStatus(List<String> statusIds);

	@Query(nativeQuery = true, value = "select * from EOGLOBAL_CURRENCY_GROUP where TYPE_ID = ?1")
	List<EOGlobalCurrencyGroup> findAllByTypeId(String typeId);
	
	int countByTypeId(String typeId);

	@Query(nativeQuery = true, value = "select * from EOGLOBAL_CURRENCY_GROUP where TYPE_ID = ?1")
	Optional<EOGlobalCurrencyGroup> findByTypeId(String typeId);

}
