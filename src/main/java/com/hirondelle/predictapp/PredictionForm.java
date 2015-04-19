package com.hirondelle.predictapp;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hirondelle.predictapp.domain.model.Outcome;
import com.hirondelle.predictapp.domain.model.PredictionList;

public class PredictionForm {
    private Integer id;
    
    private PredictionList predictionList;
    
    private Outcome outcome;
    
    @NotNull
    @Size(min = 1, max = 255)    
    private String text;
    
    private Date creationDate;
    
    @Size(min = 1, max = 2000)    
    private String remark;    
    
    private Date outcomeDate;

    private Integer parentId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PredictionList getPredictionList() {
		return predictionList;
	}

	public void setPredictionList(PredictionList predictionList) {
		this.predictionList = predictionList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Outcome getOutcome() {
		return outcome;
	}

	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	} 
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getOutcomeDate() {
		return outcomeDate;
	}

	public void setOutcomeDate(Date outcomeDate) {
		this.outcomeDate = outcomeDate;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	} 
}
