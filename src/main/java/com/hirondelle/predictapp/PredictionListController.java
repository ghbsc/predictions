package com.hirondelle.predictapp;

import javax.inject.Inject;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.service.IPredictionListService;

@Controller
@RequestMapping("prediction")
public class PredictionListController {

	@Inject
	protected IPredictionListService predictionListService;
	
	@RequestMapping("list")
	public String List(Model model) {
		List<PredictionList> predictions = predictionListService.findByUserID(1);
		model.addAttribute("predictions", predictions);
        return "lists/list";		
	}
}
