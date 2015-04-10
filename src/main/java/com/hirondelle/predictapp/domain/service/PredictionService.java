package com.hirondelle.predictapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hirondelle.predictapp.domain.model.Prediction;
import com.hirondelle.predictapp.domain.repository.IPredictionRepository;

@Service
public class PredictionService implements IPredictionService {
	@Inject
	private IPredictionRepository predictionRepository;
	
	@Override
	public List<Prediction> findByPredictionListID(int id) {
		return predictionRepository.findByPredictionListID(id);
	}

}
