package com.teno.service;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teno.model.TenoUserDetails;
import com.teno.model.UserEntity;
import com.teno.repo.UserRepository;

@Service
public class TenoUserDetailsService implements UserDetailsService{
	private UserRepository userRepository;

	@PostConstruct
    public void initialize()
    {
		userRepository.save(new UserEntity(1,"aniket","989822223","aniket.paranjpe@pebstone.com","12234444","ADMIN"));        
    }
	  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		int id=Integer.parseInt(username);
		UserEntity user=userRepository.findOne(id);
		return new TenoUserDetails(user);		
	}
	
}
