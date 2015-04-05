package com.hirondelle.predictapp;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	//Model attribute default value
	@RequestMapping("list")
	public String List(@ModelAttribute("predictionListForm") PredictionListForm predictionListForm, Model model) {		
		populatePredictionLists(model);
        return "lists/list";		
	}
	
    @RequestMapping("edit")
    public String Edit(@RequestParam("id") Integer id, Model model) {
    	PredictionList predictionList = predictionListService.findOne(id);
    	
    	PredictionListForm predictionListForm = beanMapper.map(predictionList, PredictionListForm.class);
    	model.addAttribute("predictionListForm", predictionListForm);
    	
    	populatePredictionLists(model);
        return "lists/list";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid PredictionListForm predictionListForm, 
    		BindingResult result, RedirectAttributes attr) {
    	if(result.hasErrors()) {   		
//    		populatePredictionLists(model);
    		return "lists/list";    		
    	}
    	
    	PredictionList predictionList = predictionListService.findOne(predictionListForm.getId());
    	predictionList.setTitle(predictionListForm.getTitle());
    	
    	predictionListService.save(predictionList);
    	
    	attr.addFlashAttribute("confirmationMessage", "confirmed");
        return "redirect:/prediction/list";	
    }
    
    private void populatePredictionLists(Model model) {
		List<PredictionList> predictionLists = predictionListService.findByUserID(1);
		model.addAttribute("predictionLists", predictionLists);    	
    }
}
