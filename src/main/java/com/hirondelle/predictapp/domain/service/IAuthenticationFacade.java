package com.hirondelle.predictapp.domain.service;

import com.hirondelle.predictapp.domain.model.CustomUser;

public interface IAuthenticationFacade {
    CustomUser getPrincipal();
}
