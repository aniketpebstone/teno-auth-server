package com.teno;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teno.model.TenoUserDetails;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class AuthenticationServerApplication {
	
	 @RequestMapping(value = { "/user" }, produces = "application/json")
	 public Object user(OAuth2Authentication user) 
	 {		
	        Map<String, Object> userInfo = new HashMap<>();
	        
	        userInfo.put("user", user.getPrincipal());
	        userInfo.put("scope", user.getOAuth2Request().getScope());
	        
	        return userInfo;
	 }
	 @RequestMapping(value = { "/teno-user" }, produces = "application/json")
	 public Object tenoUser(Principal principal) 
	 {				 
		 if(principal instanceof TenoUserDetails)
		 {
			 TenoUserDetails userDetails=(TenoUserDetails) principal;
			 return userDetails.getUser();
		 }
		 return principal;
	 }
	 
	 public static void main(String[] args) {
		SpringApplication.run(AuthenticationServerApplication.class, args);
	}
}
