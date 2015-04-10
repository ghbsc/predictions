package com.hirondelle.predictapp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hirondelle.predictapp.domain.model.Prediction;
import com.hirondelle.predictapp.domain.service.IPredictionService;

@Controller
@RequestMapping("prediction")
public class PredictionController {
	@Inject
	protected IPredictionService predictionService;
	
	@ModelAttribute("predictionForm")
	public PredictionForm setupPredictionForm() {
		return new PredictionForm();
	}
	
	//Model attribute default value
	@RequestMapping("list")
	public String List(@RequestParam("id") Integer id, @ModelAttribute("predictionForm") PredictionForm predictionForm, 
			Model model) {		
		populatePredictions(id, model);
        return "prediction/list";		
	}
	
    private void populatePredictions(Integer id, Model model) {
		List<Prediction> predictions = predictionService.findByPredictionListID(id);
		model.addAttribute("predictions", predictions);    	
    }	
}
