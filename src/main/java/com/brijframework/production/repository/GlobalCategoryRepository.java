package com.brijframework.production.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.production.entities.EOGlobalCategory;

@Repository
@Transactional
public interface GlobalCategoryRepository extends JpaRepository<EOGlobalCategory, Long>{
	
	List<EOGlobalCategory> findOneByTypeId(String typeId);
}
