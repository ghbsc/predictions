package com.hirondelle.predictapp.domain.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.hirondelle.predictapp.domain.model.CustomUser;
import com.hirondelle.predictapp.domain.model.User;
import com.hirondelle.predictapp.domain.model.UserRole;
import com.hirondelle.predictapp.domain.repository.IUserRepository;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService  {
	private IUserRepository userRepository;
	
	@Inject	
	public MyUserDetailsService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByLoginName(String loginName) {
		List<User> users = userRepository.findByLoginName(loginName);
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = findByLoginName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());		
		
		return buildUserForAuthentication(user, authorities);
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private CustomUser buildUserForAuthentication(User user, 
		List<GrantedAuthority> authorities) {
		return new CustomUser(user.getLoginName(), user.getPassword(), 
			true, true, true, true, authorities, user.getId());
	}	
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getLoginNameRole().getRole()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}


}
