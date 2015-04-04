package com.hirondelle.predictapp;

import java.util.Date;

import com.hirondelle.predictapp.domain.model.User;

public class PredictionListForm {
    private Integer id;
    private String title;
    private Date creationDate;
    private User user;
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setCreationDate(Date creationDate) {
    	this.creationDate = creationDate;
    }
    
    public Date getCreationDate() {
    	return creationDate;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
