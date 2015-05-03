package com.hirondelle.predictapp.domain.service;

import java.util.List;
import javax.inject.Inject;

//import org.springframework.transaction.annotation.Transactional;












import org.springframework.stereotype.Service;
import com.hirondelle.predictapp.domain.model.User;
import com.hirondelle.predictapp.domain.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	@Inject
	private IUserRepository userRepository;
	
	@Override
	//@Transactional(readOnly = true)	
	public List<User> findAll() {
		return userRepository.findAll();
	} 	
	
}
