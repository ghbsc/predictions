package com.hirondelle.predictapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirondelle.predictapp.domain.model.PredictionList;

public interface IPredictionListRepository extends JpaRepository<PredictionList, Integer> {
	
	@Query("SELECT p FROM PredictionList p WHERE p.user.id = :id")
	List<PredictionList> findByUserID(@Param("id") int id);
}
