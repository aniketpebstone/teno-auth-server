package com.teno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

import com.teno.service.TenoUserDetailsService; 
@Configuration
public class WebSecurityConfigurer extends GlobalAuthenticationConfigurerAdapter
{
	@Autowired
	TenoUserDetailsService userDetailsService;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}  
	 
}
