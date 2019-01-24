package com.app.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Transactional;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(readOnly=false)
public @interface Master {

}
