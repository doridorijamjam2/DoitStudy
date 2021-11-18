package com.spring.study.controller;

import com.spring.study.security.SecurityAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.service.AccountServiceImpl;
import com.spring.study.vo.Account;

@Controller
public class HomeController {
	
	@Autowired
	AccountServiceImpl accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goLogin() {
		return "/login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String goJoin() {
		return "/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Account account) {
		account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
		accountService.join(account);
		return "/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model, Authentication authentication) {
		if(authentication != null){
			SecurityAccount account = (SecurityAccount)authentication.getPrincipal();
			model.addAttribute("username", account.getUsername());
		}
		return "/home";
	}

}
