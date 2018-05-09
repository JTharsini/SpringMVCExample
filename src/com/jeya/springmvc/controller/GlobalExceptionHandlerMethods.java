package com.jeya.springmvc.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author JJeyatharsini If we have this, we don't need to have duplicate
 *         methods in HelloControllerAnnotationBased class
 */
@ControllerAdvice/*(basePackages = { "com.jeya.springmvc.controller" })*/
public class GlobalExceptionHandlerMethods {
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("Null Pointer Exception Occured: " + e);
		return "ViewNullPointerException";
	}

	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {
		System.out.println("IO Exception Occured: " + e);
		return "ViewIOException";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		System.out.println("Exception Occured: " + e);
		return "ViewException";
	}
}