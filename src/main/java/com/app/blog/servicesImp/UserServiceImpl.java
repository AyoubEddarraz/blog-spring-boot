package com.app.blog.servicesImp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.blog.Dto.UserDto;
import com.app.blog.entities.UserEntity;
import com.app.blog.repositories.UserRepository;
import com.app.blog.services.UserService;
import com.app.blog.utils.GenerateUserId;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GenerateUserId generateUserId;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto addNewUser(UserDto newUser) {
		
		UserEntity checkIfUserExsiste = userRepository.findByEmail(newUser.getEmail());
		
		if(checkIfUserExsiste != null) throw new RuntimeException("this email is already used try with another email.");
		
		UserEntity userEntity = new UserEntity();
		
		newUser.setUID(generateUserId.genUserID(32));
		newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
		BeanUtils.copyProperties(newUser, userEntity);
		
		UserEntity newUserCreated = userRepository.save(userEntity);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(newUserCreated, userDto);
 
		return userDto;
	}

	@Override
	public UserDto getUser(String email) {
		
		UserEntity user = userRepository.findByEmail(email);
		
		if(user == null) throw new RuntimeException(email);
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
	}


}
