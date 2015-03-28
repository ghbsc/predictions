package com.hirondelle.predictapp.domain.service;

import java.util.List;

import com.hirondelle.predictapp.domain.model.PredictionList;

public interface IPredictionListService {
	List<PredictionList> findByUserID(int id);
}
