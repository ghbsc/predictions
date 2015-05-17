package com.hirondelle.predictapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.hirondelle.predictapp.domain.model.Prediction;
import com.hirondelle.predictapp.domain.repository.IPredictionRepository;

@Service
public class PredictionService implements IPredictionService {
	private IPredictionRepository predictionRepository;
	
	@Inject	
	public PredictionService(IPredictionRepository predictionRepository) {
		this.predictionRepository = predictionRepository;
	}
	
	@Override
	public List<Prediction> findByPredictionListID(int id) {
		return predictionRepository.findByPredictionListID(id);
	}

	@Override
	public void save(Prediction prediction) {
		if(prediction.getCreationDate() == null) {
			prediction.setCreationDate(new DateTime().toDate());
		}
		
		if(prediction.getOutcome() != null) {
			prediction.setOutcomeDate(new DateTime().toDate());
		}
		
		predictionRepository.save(prediction);
	}

	@Override
	public void delete(Prediction prediction) {
		predictionRepository.delete(prediction);
	}
	
	@Override
	public Prediction findOne(Integer id) {
		return predictionRepository.findOne(id);
	}

}
