package com.app.blog.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.Dto.UserDto;
import com.app.blog.requests.UserRequest;
import com.app.blog.responses.UserResponse;
import com.app.blog.services.UserService;


@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users/singUp")
	public ResponseEntity<UserResponse> addNewUser(@RequestBody UserRequest newUser) {

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(newUser, userDto);

		UserDto user = userService.addNewUser(userDto);

		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(user, userResponse);

		return new ResponseEntity<UserResponse>(userResponse , HttpStatus.CREATED);

	}

}
