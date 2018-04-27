package com.jeya.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage"); // view name is given by controller
		
		modelAndView.addObject("welcomeMessage", "Hi user, welcome to the first Spring MVC Application");
		return modelAndView;
	}

}