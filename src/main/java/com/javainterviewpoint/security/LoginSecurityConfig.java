package com.javainterviewpoint.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

//@Configuration
//@EnableWebSecurity
//public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	
	//@Autowired
//	AdminAuthenticationProvider authenticationProvider;
	
	
	//@Autowired
	/*public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider).eraseCredentials(false);
	}*/
	

	//@Override
	//public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/css/*/**").antMatchers("/uploadpdf.htm").antMatchers("/img/*/**").antMatchers("/fonts/*/**"). 
	//	antMatchers("/health.do");
	//}
	
	
	//@Override
/*
 * protected void configure(HttpSecurity http) throws Exception {
 * 
 * 
 * http .exceptionHandling() .accessDeniedPage( "/403" ) .and()
 * .authorizeRequests() .antMatchers( "/login.htm" ).permitAll()
 * .antMatchers("/uploadpdf.htm").permitAll() .anyRequest().authenticated()
 * .and() .formLogin() .loginPage( "/login.htm" ) .loginProcessingUrl(
 * "/login.htm" ).defaultSuccessUrl("/documentmgmt.htm", true) .failureUrl(
 * "/login.htm?error" ) .usernameParameter( "username" ) .passwordParameter(
 * "password" ) .and() .logout().logoutSuccessUrl("/login.htm?logout");
 * 
 * }
 */
//}