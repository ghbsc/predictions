package com.hirondelle.predictapp.domain.service;

import java.util.List;

import com.hirondelle.predictapp.domain.model.Outcome;

public interface IOutcomeService {
	List<Outcome> findAll();
}
