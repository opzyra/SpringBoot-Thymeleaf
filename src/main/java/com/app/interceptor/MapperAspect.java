package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.security.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MapperAspect {
	
	@Autowired(required=true)
	protected HttpServletRequest request;
	
	private final String COMMASPACE = ", ";
	
	private final String NULL = "null";
	
	private final String SUCCESS = "success";
	
	private final String FAIL = "fail";
	
	@Around("execution(* com.app.mapper.*.*(..))")
	public Object sqlExecuteLog(ProceedingJoinPoint joinPoint) {

		Object result = null;
		
		String className = joinPoint.getSignature().getDeclaringTypeName().substring(21);
	    
	    String methodName = joinPoint.getSignature().getName();
	    
	    // 문자열 객체 생성
	 	StringBuffer logMessage = new StringBuffer();
	 	
	 	Long executeTime = System.currentTimeMillis();
		
	    try {

		    result = joinPoint.proceed();
	
		 	// 실행 시간
		    logMessage.append(System.currentTimeMillis() - executeTime).append(COMMASPACE);
		    
		    // 성공
		    logMessage.append(SUCCESS).append(COMMASPACE);
		    
		    // 유저 정보
		    HttpSession session = request.getSession();
	    	Object sessionAttr = session.getAttribute("user");
	    	
	    	if(sessionAttr != null) {
	    		Account user = (Account) sessionAttr;
	    		
	    		// 사용자 아이디
	    		logMessage.append(user.getEmail()).append(COMMASPACE);
	    		
	    	} else {
	    		
	    		logMessage.append(NULL).append(COMMASPACE);
	    		
	    	}
	    	
	    	// Mapper 클래스
		    logMessage.append(className).append(COMMASPACE);
		    
		    // Mapper ID
		    logMessage.append(methodName).append(COMMASPACE);
	        
	    	// 마지막 콤마 잘라내기
	        logMessage.delete(logMessage.length()-2, logMessage.length());
	        
	        // SqlLog 출력
	        log.info(logMessage.toString());
	    	
		} catch (Throwable e) {
			
			// 실행 시간
		    logMessage.append(System.currentTimeMillis() - executeTime).append(COMMASPACE);
		    
		    // 실패
		    logMessage.append(FAIL).append(COMMASPACE);
		    
		    // 유저 정보
		    HttpSession session = request.getSession();
	    	Object sessionAttr = session.getAttribute("user");
	    	
	    	if(sessionAttr != null) {
	    		Account user = (Account) sessionAttr;
	    		
	    		// 사용자 아이디
	    		logMessage.append(user.getEmail()).append(COMMASPACE);
	    		
	    	} else {
	    		
	    		logMessage.append(NULL).append(COMMASPACE);
	    		
	    	}
	    	
	    	// Mapper 클래스
		    logMessage.append(className).append(COMMASPACE);
		    
		    // Mapper ID
		    logMessage.append(methodName).append(COMMASPACE);
	    	
	    	// 마지막 콤마 잘라내기
	        logMessage.delete(logMessage.length()-2, logMessage.length());
			
			log.error(logMessage.toString());
		}
	    
	    return result;
	    
	}
	
}
