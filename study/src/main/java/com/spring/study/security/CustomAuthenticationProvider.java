package com.spring.study.security;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.study.vo.MemberVO;

@SuppressWarnings("unused")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
	private UserDetailsService service;
	@Inject
	private BCryptPasswordEncoder passDecoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userId = (String)authentication.getPrincipal();
		String userPass = (String)authentication.getCredentials();

		//db에서 회원 정보 가져옴
		CustomUserDetails user = (CustomUserDetails)service.loadUserByUsername(userId);

		
		if(passDecoder.matches(userPass, user.getPassword())) {
			System.out.println("매칭 완료");
		}
		if(!passDecoder.matches(userPass, user.getPassword())) {
			 throw new BadCredentialsException(userPass);
		}


		//user 정보 들어가는지 test
		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}