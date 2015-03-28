package com.hirondelle.predictapp.domain.model;

import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "predictionlist")
public class PredictionList {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "userfK")
    private User user;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "creationdate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    
    public Integer getId() {
    	return id;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public Date getCreationDate() {
    	return creationDate;
    }
}
