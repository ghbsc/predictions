package com.hirondelle.predictapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.repository.IPredictionListRepository;

@Service
//@Transactional
public class PredictionListService implements IPredictionListService {
	@Inject
	private IPredictionListRepository predictionListRepository;
	
	@Override
	public List<PredictionList> findByUserID(int id) {
		return predictionListRepository.findByUserID(id);
	}
}
