package com.jeya.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeya.springmvc.model.Student;

//@Controller is also allowed
@RestController
public class StudentInfoRESTAPIController {
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentsList() {
		Student student1 = new Student();
		student1.setStudentName("Khali");

		Student student2 = new Student();
		student2.setStudentName("Nisha");

		Student student3 = new Student();
		student3.setStudentName("Usha");

		List<Student> studentsList = new ArrayList<>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);

		return studentsList;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("WWE");
		return student;
	}
}