package com.app.blog.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.blog.servicesImp.UserDetailsServiceImpl;

@EnableWebSecurity()
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private final UserDetailsServiceImpl userdetailsServiceImpl;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserDetailsServiceImpl userdetailsServiceImpl, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userdetailsServiceImpl = userdetailsServiceImpl;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST , SecurityConstantes.SIGN_UP_URL).permitAll() // signUp
			.anyRequest().authenticated().and()
			.addFilter(getAuthenticationFilter())
			.addFilter(new AuthorizationFilter(authenticationManager()))
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/api/v1/users/login");
		return filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}
	
}