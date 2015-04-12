package com.hirondelle.predictapp.domain.model;

import java.util.Date;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Prediction")
public class Prediction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    private Integer id;
    
	@ManyToOne(targetEntity = PredictionList.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "predictionlistfk")
    private PredictionList predictionList;
    
	@OneToOne(targetEntity = Outcome.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "outcomefk")
    private Outcome outcome;
    
    @Column(name = "text", nullable = false)
    private String text;
    
    @Column(name = "creationdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    @Column(name = "remark")
    private String remark;    
    
    @Column(name = "outcomedate")
    @Temporal(TemporalType.DATE)
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
}
