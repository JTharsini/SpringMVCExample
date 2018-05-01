package com.jeya.springmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeya.springmvc.model.Student;

@Controller
public class StudentAdmissionController {
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(
			@RequestParam(value = "studentName", defaultValue = "Mr.ABCXYZ") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("msg", "Details submitted by you:: Name: " + name + ", Hobby: " + hobby);
		return modelAndView;
	}

	@RequestMapping(value = "/submitAdmissionForm2.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormWithMap(@RequestParam Map<String, String> reqPar) {
		String name = reqPar.get("studentName");
		String hobby = reqPar.get("studentHobby");
		
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby(hobby);
		
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		
		modelAndView.addObject("headerMessage", "Details submitted by you");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
}