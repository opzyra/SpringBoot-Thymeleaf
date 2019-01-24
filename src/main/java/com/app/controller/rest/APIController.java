package com.app.controller.rest;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.param.TestParam;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@GetMapping("/test")
	public String test(@Valid @ModelAttribute TestParam param) {
		return param.getName() + ", hello";
	}
	
}
