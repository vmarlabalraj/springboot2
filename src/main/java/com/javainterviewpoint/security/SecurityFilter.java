package com.javainterviewpoint.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.DelegatingFilterProxy;

public class SecurityFilter extends DelegatingFilterProxy{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		if(httpServletRequest.getRequestURL().indexOf("uploadpdf")==-1 || httpServletRequest.getRequestURL().indexOf("saveimage")==-1)
			super.doFilter(request, response, filterChain);
		
	}
}
