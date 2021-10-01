package com.app.blog.services;

import com.app.blog.Dto.UserDto;

public interface UserService {

	UserDto addNewUser(UserDto newUser); 
	
	UserDto getUser(String email);

}
