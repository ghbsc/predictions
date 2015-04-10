package com.hirondelle.predictapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirondelle.predictapp.domain.model.Prediction;

public interface IPredictionRepository extends JpaRepository<Prediction, Integer> {
	@Query("SELECT p FROM Prediction p WHERE p.predictionList.id = :id")
	List<Prediction> findByPredictionListID(@Param("id") int id);
}
