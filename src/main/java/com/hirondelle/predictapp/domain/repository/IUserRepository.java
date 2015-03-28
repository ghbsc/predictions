package com.hirondelle.predictapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirondelle.predictapp.domain.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	//List<User> findAll();
}
