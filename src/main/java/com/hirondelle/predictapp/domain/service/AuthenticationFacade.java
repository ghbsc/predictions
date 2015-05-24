package com.hirondelle.predictapp.domain.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.hirondelle.predictapp.domain.model.CustomUser;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

	@Override
	public CustomUser getPrincipal() {
		return (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
