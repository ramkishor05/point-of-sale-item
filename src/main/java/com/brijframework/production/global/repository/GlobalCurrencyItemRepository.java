package com.brijframework.production.global.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.global.entities.EOGlobalCurrencyItem;

@Repository
@Transactional
public interface GlobalCurrencyItemRepository extends JpaRepository<EOGlobalCurrencyItem, Long>{
	
	Optional<EOGlobalCurrencyItem> findOneByIdenNo(String idenNo);
	
	List<EOGlobalCurrencyItem> findOneByTypeId(String typeId);

	int countByTypeId(String typeId);
}
