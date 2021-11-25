package com.spring.study.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/index.html")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/vip.html")
	public String vip(Model model) {
		return "vip";
	}
	
	@RequestMapping("/admin.html")
	public String admin(Model model) {
		return "admin";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
}