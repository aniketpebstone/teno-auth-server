package com.teno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter
{
    
    public void configure(HttpSecurity http) throws Exception {
    	http.
    	csrf().disable();
    
    }
        
   public void configure(WebSecurity web) throws Exception {
        web
          .ignoring()
            .antMatchers("/create-user");
    }
	 
}
