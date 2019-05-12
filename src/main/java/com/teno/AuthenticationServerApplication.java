package com.teno;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teno.model.TenoUserDetails;
import com.teno.model.UserEntity;
import com.teno.service.TenoUserDetailsService;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class AuthenticationServerApplication {
	
	 @Autowired
	 private TenoUserDetailsService userDetailsService;
	 
	 @RequestMapping(value = { "/user" }, produces = "application/json")
	 public Object user(OAuth2Authentication auth2Authentication) 
	 {	
		 HashMap<String, Object> map=new HashMap<>();
		 map.put("user", ((TenoUserDetails)auth2Authentication.getUserAuthentication().getPrincipal()).getUser());
		 map.put("authorities", auth2Authentication.getAuthorities());
		 map.put("oauth2Request", auth2Authentication.getOAuth2Request());		 
		 return map;
	 }
	 
	 @PostMapping(value = { "/create-user" }, produces = "application/json")
	 public void createUser(@RequestBody UserEntity user) 
	 {	
		 userDetailsService.createTenoUser(user);
		 System.out.println("User created successfully!");
	 }
	
	 
	 public static void main(String[] args) {
		SpringApplication.run(AuthenticationServerApplication.class, args);
	}
}
