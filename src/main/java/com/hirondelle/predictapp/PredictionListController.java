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
import com.hirondelle.predictapp.domain.model.User;
import com.hirondelle.predictapp.domain.service.IPredictionListService;

@Controller
@RequestMapping("predictionlist")
public class PredictionListController {
	protected IPredictionListService predictionListService;
	
	protected Mapper beanMapper;
	
	@Inject	
	public PredictionListController(IPredictionListService predictionListService, 
									Mapper beanMapper) {
		this.predictionListService = predictionListService;
		this.beanMapper = beanMapper;
	}
	
	@ModelAttribute("predictionListForm")
	public PredictionListForm setupPredictionListForm() {
		return new PredictionListForm();
	}
	
	//Model attribute default value 
	//Wild card e.g. "/welcome**"
	@RequestMapping(value = { "list" })
	public String List(@ModelAttribute("predictionListForm") PredictionListForm predictionListForm, 
			Model model) {		
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
    
    //The binding result should follow the object being validated
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid PredictionListForm predictionListForm, BindingResult result, 
    		Model model, RedirectAttributes attr) {
    	if(result.hasErrors()) {   		
    		populatePredictionLists(model);
    		return "lists/list";    		
    	}
    	
    	PredictionList predictionList = getPredictionList(predictionListForm);
    	
    	beanMapper.map(predictionListForm, predictionList);
    	predictionListService.save(predictionList);
    	
    	attr.addFlashAttribute("confirmationMessage", "Your list has been changed successfully.");
        return "redirect:/predictionlist/list";	
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer id, Model model, 
    		RedirectAttributes attr) {
    	PredictionList predictionList = predictionListService.findOne(id);
    	predictionListService.delete(predictionList);
    	
    	attr.addFlashAttribute("confirmationMessage", "Your list has been deleted.");	
        return "redirect:/predictionlist/list";	    	
    }
    
    private PredictionList getPredictionList(PredictionListForm predictionListForm) {
 		PredictionList predictionList;
 		
    	if(predictionListForm.getId() == null) {
    		predictionList = new PredictionList();
    		
    		User user = new User();
    		user.setId(1);
    		predictionList.setUser(user);
    	}
    	else {
        	predictionList = predictionListService.findOne(predictionListForm.getId());    		
    	} 		
 		
 		return predictionList;
    }    
    
    private void populatePredictionLists(Model model) {
		List<PredictionList> predictionLists = predictionListService.findByUserID(1);
		model.addAttribute("predictionLists", predictionLists);    	
    }
}
