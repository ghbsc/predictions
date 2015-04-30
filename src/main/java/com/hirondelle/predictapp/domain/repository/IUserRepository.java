package com.hirondelle.predictapp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirondelle.predictapp.domain.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.loginName = :loginName")	
	List<User> findByLoginName(@Param("loginName") String loginName);
}
