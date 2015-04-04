package com.hirondelle.predictapp.domain.service;

import java.util.List;

import com.hirondelle.predictapp.domain.model.PredictionList;

public interface IPredictionListService {
	void save(PredictionList predictionList);
	
	List<PredictionList> findByUserID(int id);
	
	PredictionList findOne(Integer id);
}
