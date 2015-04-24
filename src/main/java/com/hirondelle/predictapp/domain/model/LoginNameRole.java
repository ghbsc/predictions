package com.hirondelle.predictapp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoginNameRole implements Serializable {
    /**
	 * 
	 */	
	private static final long serialVersionUID = 1L;

	@Column(name = "loginname", nullable = false, unique = true)
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
//	@ManyToOne
//  @JoinColumns ({
//      @JoinColumn(name="loginName", referencedColumnName="loginName", insertable=false, updatable=false)
//  })	
//  private User user;	
}
