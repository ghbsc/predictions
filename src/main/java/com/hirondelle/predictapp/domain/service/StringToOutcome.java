package com.hirondelle.predictapp.domain.service;

import javax.inject.Inject;

import org.springframework.core.convert.converter.Converter;

import com.hirondelle.predictapp.domain.model.Outcome;
import com.hirondelle.predictapp.domain.repository.IOutcomeRepository;

public class StringToOutcome implements Converter<String, Outcome> {
	@Inject
	protected IOutcomeRepository outcomeRepository;
	
	@Override
	public Outcome convert(String text) {
		return outcomeRepository.findByText(text);
	}

}
