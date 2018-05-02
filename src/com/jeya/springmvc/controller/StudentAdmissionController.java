package com.jeya.springmvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jeya.springmvc.model.Student;
import com.jeya.springmvc.springspeccustom.StudentNameEditor;

@Controller
public class StudentAdmissionController {
	@InitBinder
	public void goingToDisableAFieldBinding(WebDataBinder binder)
	{
		binder.setDisallowedFields(new String[]{"studentMobile"});
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****mm****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor()); // custom property editor class is registered here
		// since we registered our custom class for studentName, Spring MVC will consult that class
		// before bind a value for it
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model)
	{
		// spring mvc will make call for a method annotated with ModelAttribute before
		// executing a method to serve a request
		model.addAttribute("headerMessage", "Chava Hindu College");
		// modelAndView.addObject("headerMessage", "Chava Hindu College"); in each method can be replaced by adding
		// this method annotated with ModelAttribute
	}
	
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		//modelAndView.addObject("headerMessage", "Chava Hindu College");
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

		//modelAndView.addObject("headerMessage", "Chava Hindu College");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

	@RequestMapping(value = "/submitAdmissionForm3.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormWithModelAttribute(@ModelAttribute("student") Student student) {
		// here @ModelAttribute get request params from request and bind those to related attributes of
		// student object. Then it binds the object to model and view
		// It finds the attribute to bind for a request param by their names ==> Naming
		// should match
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");

		//modelAndView.addObject("headerMessage", "Chava Hindu College");
		return modelAndView;
	}
	
	@RequestMapping(value = "/submitAdmissionForm4.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormWithVariousDataType(@RequestParam("studentName") String name, 
																@RequestParam("studentHobby") String hobby,
																@RequestParam("studentMobile") String mobile,
																@RequestParam("studentDOB") String DOB,
																@RequestParam("studentSkills") String[] skillsSet)
	{
		Student student = new Student();
		try
		{
			student.setStudentName(name);
			student.setStudentHobby(hobby);
			student.setStudentMobile(Long.parseLong(mobile));
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			student.setStudentDOB(format.parse(DOB));
			
			List<String> skillsSetList = new ArrayList<>();
			for(int i = 0; i < skillsSet.length; i++)
			{
				skillsSetList.add(skillsSet[i]);
			}
			student.setStudentSkills(skillsSetList);
		}
		catch(Exception e)
		{
			
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping(value = "/submitAdmissionForm5.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormWithErrorHandling(@ModelAttribute("student") Student student, BindingResult result) {
		// BindingResult should be placed immediately after the parameter annotated with @ModelAttribute
		if(result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("AdmissionForm");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("AdmissionSuccess");

		//modelAndView.addObject("headerMessage", "Chava Hindu College");
		return modelAndView;
	}
}