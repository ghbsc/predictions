package com.hirondelle.predictapp.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {

	@EmbeddedId	
	private LoginNameRole loginNameRole;
	
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "loginName")
    private User user;

	public LoginNameRole getLoginNameRole() {
		return loginNameRole;
	}

	public void setLoginNameRole(LoginNameRole loginNameRole) {
		this.loginNameRole = loginNameRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
