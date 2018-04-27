package com.jeya.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllerAnnotationBased {

	@RequestMapping("/welcomeByAnnotation")
	protected ModelAndView helloWorld() throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi user, welcome to the first Spring MVC Application");
		return modelAndView;
	}
}