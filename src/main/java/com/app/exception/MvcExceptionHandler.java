package com.app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(basePackages="com.app.controller.mvc")
public class MvcExceptionHandler {
	
	private static final String VIEW_PREFIX = "error/";
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleMethodException(Exception e) {
		log.error("MvcException", e);
		return new ModelAndView(VIEW_PREFIX + "exception");
	}
}
