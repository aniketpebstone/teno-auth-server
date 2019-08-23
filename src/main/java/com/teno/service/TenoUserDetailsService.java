package com.teno.service;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teno.model.Role;
import com.teno.model.TenoUserDetails;
import com.teno.model.UserEntity;
import com.teno.repo.UserRepository;

@Service
public class TenoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

//	@PostConstruct
//    public void initialize()
//    {
//		UserEntity user=new UserEntity();
//		user.setId(1);
//		user.setPassword("aniket");
//		user.setFirstName("Aniket");
//		user.setLastName("Paranjpe");
//		user.setEmail("aniket.paranjpe@pebstone.com");
//		user.setPhone("1234524244");
//		user.setRoleId(Role.ADMIN.value);
//		user.setIsActive(true);
//		user.setIsDeleted(false);
//		userRepository.save(user);		
//		
//    }
	  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		int id=Integer.parseInt(username);
		UserEntity user=userRepository.findOne(id);
		return new TenoUserDetails(user);		
	}
	
	public void createTenoUser(UserEntity user)
	{
		userRepository.save(user);
	}
	
}
