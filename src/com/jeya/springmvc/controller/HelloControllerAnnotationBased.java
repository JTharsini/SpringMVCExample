package com.jeya.springmvc.controller;

import org.springframework.stereotype.Controller;
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

	@RequestMapping("/hi") // now http://localhost:8090/FirstSpringMVCProject/greet/hi is needed to execute this method
	protected ModelAndView hi() throws Exception {
		ModelAndView modelAndView = new ModelAndView("HelloPage");

		modelAndView.addObject("welcomeMessage", "Hi Hi Hi");
		return modelAndView;
	}
}