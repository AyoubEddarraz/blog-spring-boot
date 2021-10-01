package com.app.blog.servicesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.blog.entities.UserEntity;
import com.app.blog.repositories.UserRepository;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity user = userRepository.findByEmail(email);
		
		if(user == null)  throw new UsernameNotFoundException(email + " is not Exsiste.");
		
		return new User(user.getEmail() , user.getPassword(), new ArrayList<>());
	}
	
}
