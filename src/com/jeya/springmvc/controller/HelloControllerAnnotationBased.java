package com.jeya.springmvc.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloControllerAnnotationBased {

	@RequestMapping("/welcomeByAnnotation")
	protected ModelAndView helloWorld() throws Exception { // a request handler
															// method
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi user, welcome to the first Spring MVC Application");
		return modelAndView;
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Exception e)
	{
		// logging Null Pointer Exception
		System.out.println("Null Pointer Exception Occured: " + e);
		return "ViewNullPointerException"; // name of JSP
	}
	
	@ExceptionHandler(value=IOException.class)
	public String handleIOException(Exception e)
	{
		System.out.println("IO Exception Occured: " + e);
		return "ViewIOException";
	}
	
	// writing separate methods for each and every exception is pain. To avoid, can write
	// generic exception handling method
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e)
	{
		System.out.println("Exception Occured: " + e);
		return "ViewException";
	}
	
	@RequestMapping("/welcomeWithError")
	protected ModelAndView forExceptionHandling() throws Exception {
		String exceptionOccurred = "MY_EXCEPTION";
		if("NULL_POINTER".equalsIgnoreCase(exceptionOccurred))
		{
			throw new NullPointerException("Null Pointer Exception");
		}
		else if("IO_EXCEPTION".equalsIgnoreCase(exceptionOccurred))
		{
			throw new IOException("IO Exception");
		}
		else if("MY_EXCEPTION".equalsIgnoreCase(exceptionOccurred))
		{
			throw new Exception("My Exception");
		}
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi user, welcome to the first Spring MVC Application");
		return modelAndView;
	}

	@RequestMapping("/hi") // now http://localhost:8090/FirstSpringMVCProject/greet/hi is needed to execute this method
	protected ModelAndView hi() throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi Hi Hi");
		return modelAndView;
	}
	
	@RequestMapping("/welcome/{countryName}/{userName}") // now http://localhost:8090/FirstSpringMVCProject/greet/welcome/{SL}/{JayJay} is needed to execute this method
	protected ModelAndView pathVariableAsParameter(@PathVariable String countryName, @PathVariable("userName") String brrr) throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi " + brrr + " from " + countryName);
		return modelAndView;
	}
	
	@RequestMapping("/welcome/{var1}/{var2}/{var3}/{var4}") // now http://localhost:8090/FirstSpringMVCProject/greet/welcome/{var1}/{var2}/{var3}/{var4}
	protected ModelAndView pathVariableAsMap(@PathVariable Map<String, String> pathVars) throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "var1 : " + pathVars.get("var1") 
			+ ", var2 : " + pathVars.get("var2")
			+ ", var3 : " + pathVars.get("var3")
			+ ", var4 : " + pathVars.get("var4"));
		return modelAndView;
	}
}