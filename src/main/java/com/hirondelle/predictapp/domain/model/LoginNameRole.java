package com.hirondelle.predictapp.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoginNameRole {
    @Column(name = "loginName", nullable = false, unique = true)
    private String loginName;
    
    @Column(name = "role", nullable = false)
    private String role;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}    
}
