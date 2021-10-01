package com.app.blog.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.blog.SpringApplicationContext;
import com.app.blog.Dto.UserDto;
import com.app.blog.requests.UserLoginRequest;
import com.app.blog.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
		
	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

		try {
			
			UserLoginRequest creds = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequest.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

		String email = ((User) authResult.getPrincipal()).getUsername();
		
		UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
		
		UserDto userDto = userService.getUser(email);
		
		String token = Jwts.builder()
						.setSubject(email)
						.claim("UID", userDto.getUID())
						.claim("admin", userDto.getAdmin())
						.setExpiration(new Date(System.currentTimeMillis() + SecurityConstantes.EXPIRATION_TIME))
						.signWith(SignatureAlgorithm.HS512, SecurityConstantes.TOKEN_SECRET).compact();
		
		
		response.addHeader(SecurityConstantes.HEADER_STRING, SecurityConstantes.TOKEN_PREFIX+token);
		response.addHeader("UID", userDto.getUID());
		
		response.getWriter().write("{\"token\": \"" + token + "\" , \"uid\": \"" + userDto.getUID() + "\" }");
		
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		
		throw new UsernameNotFoundException("Email or mot de passe Incorrect.");
		
	}
	
	
	
	
	
	
	
	
	
	 

}
