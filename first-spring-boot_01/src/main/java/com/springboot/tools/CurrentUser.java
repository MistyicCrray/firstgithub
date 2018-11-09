package com.springboot.tools;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.PARAMETER) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface CurrentUser {

}
