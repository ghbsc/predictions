package com.hirondelle.predictapp.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Prediction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
	@ManyToOne(targetEntity = PredictionList.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "PredictionListFK")
    private PredictionList predictionList;
    
	@OneToOne(targetEntity = Outcome.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "OutcomeFK")
    private Outcome outcome;
    
    private String text;
    
    private Date creationDate;
    
    private String remark;    
    
    private Date outcomeDate;

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
}
