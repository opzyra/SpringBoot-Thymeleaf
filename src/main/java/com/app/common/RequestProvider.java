package com.app.common;

import javax.servlet.http.HttpServletRequest;

public class RequestProvider {

	private static final String UNKONW = "unknown";
	
	public static String getClientIp(HttpServletRequest request) {
		
        String ip = null;
        
        ip = request.getHeader("X-Forwarded-For");
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-RealIP"); 
        } 
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getHeader("REMOTE_ADDR");
        }
        
        if (ip == null || ip.length() == 0 || UNKONW.equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        
        return ip;
	        
	}
	
	public static String getDeviceType(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		
		if(header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if(header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if(header.indexOf("Opera") > -1) {
			return "Opera";
		} else if(header.indexOf("Firefox") > -1) {
			return "Firefox";
		} else if(header.indexOf("rv:") > -1) {
			return "MSIE";
		} else if(header.indexOf("iPhone") > -1) {
			return "Iphone";
		} else if(header.indexOf("iPad") > -1) {
			return "Ipad";
		} else if(header.indexOf("Android") > -1) {
			return "Android";
		} else if(header.indexOf("BlackBerry") > -1) {
			return "BlackBerry";
		} else if(header.indexOf("symbian") > -1) {
			return "Symbian";
		} else if(header.indexOf("sony") > -1) {
			return "Sony";
		} else if(header.indexOf("Mobile") > -1) {
			return "Mobile";
		}		
		return "undefined";
	}
	
	public static String getRequestType(HttpServletRequest request) {
		String header = request.getHeader("content-type");
		if(header != null && header.indexOf("json") > -1) {
			return "REST";
		} else {
			return "VIEW";
		}
	}
	
}
