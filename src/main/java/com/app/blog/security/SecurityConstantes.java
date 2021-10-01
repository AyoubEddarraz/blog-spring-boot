package com.app.blog.security;

public class SecurityConstantes {
		
	public static final long   EXPIRATION_TIME = 864000000; // 10 Days age of TOKEN
	public static final String TOKEN_PREFIX    = "Bearer ";
	public static final String HEADER_STRING   = "Authorization";
	public static final String SIGN_UP_URL     = "/api/v1/users/singUp";
	public static final String TOKEN_SECRET    = "QnRUYjsWPl0A7M4Dn7tV3QHSQowlo234jiF0N8BzR3lVgFnrpn";

}
