package com.hirondelle.predictapp.domain.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hirondelle.predictapp.domain.model.Prediction;

public interface IPredictionService {
	List<Prediction> findByPredictionListID(@Param("id") int id);
}
