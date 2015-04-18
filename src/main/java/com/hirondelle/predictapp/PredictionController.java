package com.hirondelle.predictapp;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hirondelle.predictapp.domain.model.Outcome;
import com.hirondelle.predictapp.domain.model.Prediction;
import com.hirondelle.predictapp.domain.model.PredictionList;
import com.hirondelle.predictapp.domain.service.IOutcomeService;
import com.hirondelle.predictapp.domain.service.IPredictionService;

@Controller
@RequestMapping("prediction")
public class PredictionController {
	@Inject
	protected IPredictionService predictionService;
	
	@Inject
	protected IOutcomeService outcomeService;
	
//	@Inject
//	protected ConversionService conversionService;

	@Inject
	protected Mapper beanMapper;	
	
//	  <annotation-driven conversion-service replaces this	
//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setConversionService(conversionService);
//    }

	//Model attribute default value
	@RequestMapping("list")
	public String List(@RequestParam("parentId") Integer parentId, Model model) {
		
		initModelList(model);
		initPredictionForm(parentId, model);
		populatePredictions(parentId, model);
		
        return "prediction/list";		
	}
	
   @RequestMapping(value = "update", method = RequestMethod.POST)
   public String update(@Valid PredictionForm predictionForm, BindingResult result, 
    		Model model, RedirectAttributes attr) {
		if(result.hasErrors()) {   		
			populatePredictions(predictionForm.getParentId(), model);
			return "prediction/list";    		
		}
		
    	Prediction prediction = getPrediction(predictionForm);
		
    	beanMapper.map(predictionForm, prediction);
    	predictionService.save(prediction);
    	
    	attr.addFlashAttribute("confirmationMessage", "Prediction has been changed successfully.");
        return String.format("redirect:/prediction/list?parentId=%s", predictionForm.getParentId());	
   }

	private Prediction getPrediction(PredictionForm predictionForm) {
		Prediction prediction;
		
		if(predictionForm.getId() == null) {
			prediction = new Prediction();
			
			PredictionList predictionList = new PredictionList();
			predictionList.setId(predictionForm.getParentId());
			prediction.setPredictionList(predictionList);
			
			if(predictionForm.getOutcome() != null) {
		   		Outcome outcome = new Outcome();
		   		outcome.setId(predictionForm.getOutcome().getId());
		   		prediction.setOutcome(outcome);    			
			}
		}
		else {
		   	prediction = predictionService.findOne(predictionForm.getId());    		
		}
		
		return prediction;
	}
   
   private void populatePredictions(Integer parentId, Model model) {
		List<Prediction> predictions = predictionService.findByPredictionListID(parentId);
		model.addAttribute("predictions", predictions);    	
   }
   
   //Cannot @ModelAttribute("predictionForm") because of the need
   //to pass parentId
   private void initPredictionForm(Integer parentId, Model model) {
    	PredictionForm predictionForm = new PredictionForm();
    	predictionForm.setParentId(parentId);
    	model.addAttribute("predictionForm", predictionForm);
   }
    
   private void initModelList(Model model) {
    	List<Outcome> outcomes = outcomeService.findAll();
    	model.addAttribute("outcomes", outcomes);
   }
}
