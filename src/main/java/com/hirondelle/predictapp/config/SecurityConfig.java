package com.hirondelle.predictapp.config;

//import javax.inject.Inject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Inject
//	@Qualifier("userDetailsService")
//	UserDetailsService userDetailsService;
//	
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().antMatchers("/**")
//		.hasRole("USER")
//		.and().formLogin()
//		.loginPage("/login").failureUrl("/login?error")
//			.usernameParameter("loginname")
//			.passwordParameter("password")
//			.and().logout().logoutSuccessUrl("/login?logout")
//			.and().csrf()
//			.and().exceptionHandling().accessDeniedPage("/403");
//		
////	    http
////	    	.authorizeRequests()//.antMatchers("/**")
////				.antMatchers("/resources/**").permitAll()
////				.anyRequest().authenticated()
////				.and()	    	
////	    //.hasRole("USER")
////			.formLogin()
////				.loginPage("/login")//.failureUrl("/login?error")
////				.permitAll()
////				.usernameParameter("loginname")
////				.passwordParameter("password")				
////				.and()
////			.logout()
////				.permitAll()
////				.and()
////			.csrf();
//	}	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}	
//}
