package com.hirondelle.predictapp;

import javax.inject.Inject;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.service.IPredictionListService;

@Controller
@RequestMapping("prediction")
public class PredictionListController {

	@Inject
	protected IPredictionListService predictionListService;
	
	@ModelAttribute("predictionList")
	public PredictionList setupPredictionList() {
		return new PredictionList();
	}
	
	@RequestMapping("list")
	public String List(@ModelAttribute("predictionList") PredictionList predictionList, Model model) {		
		PopulatePredictionLists(model);
        return "lists/list";		
	}
	
    @RequestMapping("edit")
    public String Edit(@RequestParam("id") Integer id, Model model) {
    	PredictionList predictionList = predictionListService.findOne(id);
    	model.addAttribute("predictionList", predictionList);
    	
    	PopulatePredictionLists(model);
        return "lists/list";
    }
    
    private void PopulatePredictionLists(Model model) {
		List<PredictionList> predictionLists = predictionListService.findByUserID(1);
		model.addAttribute("predictionLists", predictionLists);    	
    }
}
