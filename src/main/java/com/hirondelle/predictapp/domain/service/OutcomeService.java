package com.hirondelle.predictapp.domain.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hirondelle.predictapp.domain.model.Outcome;
import com.hirondelle.predictapp.domain.repository.IOutcomeRepository;

@Service
public class OutcomeService implements IOutcomeService {
	@Inject
	private IOutcomeRepository outcomeRepository;
	
	@Override
	public List<Outcome> findAll() {
		return outcomeRepository.findAll();
	}
}
