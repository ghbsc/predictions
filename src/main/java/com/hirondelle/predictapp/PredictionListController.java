package com.hirondelle.predictapp;

import javax.inject.Inject;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@Inject
	protected Mapper beanMapper;
	
	@ModelAttribute("predictionListForm")
	public PredictionListForm setupPredictionListForm() {
		return new PredictionListForm();
	}
	
	@RequestMapping("list")
	public String List(@ModelAttribute("predictionListForm") PredictionListForm predictionListForm, Model model) {		
		PopulatePredictionLists(model);
        return "lists/list";		
	}
	
    @RequestMapping("edit")
    public String Edit(@RequestParam("id") Integer id, Model model) {
    	PredictionList predictionList = predictionListService.findOne(id);
    	
    	PredictionListForm predictionListForm = beanMapper.map(predictionList, PredictionListForm.class);
    	model.addAttribute("predictionListForm", predictionListForm);
    	
    	PopulatePredictionLists(model);
        return "lists/list";
    }
    
    @RequestMapping("update")
    public String update(PredictionList predictionList, BindingResult result) {
    	predictionListService.findOne(predictionList.getId());
    	
        return "lists/list";	
    }
    
    private void PopulatePredictionLists(Model model) {
		List<PredictionList> predictionLists = predictionListService.findByUserID(1);
		model.addAttribute("predictionLists", predictionLists);    	
    }
}
