package com.hirondelle.predictapp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hirondelle.predictapp.domain.model.Outcome;
import com.hirondelle.predictapp.domain.model.Prediction;
import com.hirondelle.predictapp.domain.service.IOutcomeService;
import com.hirondelle.predictapp.domain.service.IPredictionService;

@Controller
@RequestMapping("prediction")
public class PredictionController {
	@Inject
	protected IPredictionService predictionService;
	
	@Inject
	protected IOutcomeService outcomeService;
	
	@ModelAttribute("predictionForm")
	public PredictionForm setupPredictionForm() {
		return new PredictionForm();
	}
	
	//Model attribute default value
	@RequestMapping("list")
	public String List(@RequestParam("parentId") Integer parentId, @ModelAttribute("predictionForm") PredictionForm predictionForm, 
			Model model) {
		
		initModelList(model);
		populatePredictions(parentId, model);
		
        return "prediction/list";		
	}
	
    private void populatePredictions(Integer parentId, Model model) {
		List<Prediction> predictions = predictionService.findByPredictionListID(parentId);
		model.addAttribute("predictions", predictions);    	
    }
    
    private void initModelList(Model model) {
    	List<Outcome> outcomes = outcomeService.findAll();
    	model.addAttribute("outcomes", outcomes);
    }
}
