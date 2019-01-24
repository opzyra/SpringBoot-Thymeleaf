package com.app.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
	
	private static final String VIEW_PREFIX = "error/";
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		log.error("GlobalException", e);
		return new ModelAndView(VIEW_PREFIX + "exception");
	}

}
