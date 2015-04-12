package com.hirondelle.predictapp.domain.service;

import java.util.List;

import com.hirondelle.predictapp.domain.model.Prediction;

public interface IPredictionService {
	List<Prediction> findByPredictionListID(int id);
}
