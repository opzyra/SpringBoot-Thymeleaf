package com.app.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private static final String VIEW_PREFIX = "page/";
	
	@GetMapping
	public String loginView() {
		return VIEW_PREFIX + "main";
	}
	
}
