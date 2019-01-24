package com.app.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	private static final String VIEW_PREFIX = "page/";
	
	@GetMapping("/login")
	public String loginView() {
		return VIEW_PREFIX + "login";
	}
	
}
