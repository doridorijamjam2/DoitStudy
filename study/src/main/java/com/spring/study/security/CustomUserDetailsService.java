package com.spring.study.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.study.dao.MemberDAO;

public class CustomUserDetailsService implements UserDetailsService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		CustomUserDetails user = dao.login(userId);
		
		
		if(user == null) {
			throw new UsernameNotFoundException(userId);
		}
		return user;
	}
}