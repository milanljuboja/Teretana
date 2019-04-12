package com.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationFilter implements javax.servlet.Filter {

	LoginService loginService;

	@Autowired
	public JWTAuthenticationFilter(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String token = httpRequest.getHeader("token");

		if (httpRequest.getRequestURI().contains("radnik/login")) {
			chain.doFilter(request, response);
			return;
		}
		if (httpRequest.getRequestURI().contains("json")) {
			chain.doFilter(request, response);
			return;
		}
		if (token != null && loginService.proveriToken(token)) {
			chain.doFilter(request, response);
			} 
		else
			httpResponse.setStatus(401);
	}
}
