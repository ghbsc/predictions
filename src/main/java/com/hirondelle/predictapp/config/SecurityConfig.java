package com.hirondelle.predictapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	    http.authorizeRequests().antMatchers("/**")
	    .hasRole("USER")
		.and().formLogin()
		//.loginPage("/login").failureUrl("/login?error")
		.usernameParameter("loginName")
		.passwordParameter("password")
		//.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf();
		//.and().exceptionHandling().accessDeniedPage("/403");
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}	
}
