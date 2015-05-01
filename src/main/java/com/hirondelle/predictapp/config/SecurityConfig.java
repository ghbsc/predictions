package com.hirondelle.predictapp.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hirondelle.predictapp.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	private UserService userService;
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	    http
	    	.authorizeRequests()//.antMatchers("/**")
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
				.and()	    	
	    //.hasRole("USER")
			.formLogin()
				.loginPage("/login")//.failureUrl("/login?error")
				.permitAll()
				.usernameParameter("loginname")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll()
				.and()
			.csrf();
		//.and().logout().logoutSuccessUrl("/login?logout")
		//.and().exceptionHandling().accessDeniedPage("/403");
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}	
}
