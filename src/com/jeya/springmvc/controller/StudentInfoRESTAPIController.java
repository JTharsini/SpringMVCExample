package com.jeya.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeya.springmvc.model.Student;

//@Controller is also allowed
@RestController
public class StudentInfoRESTAPIController {
	// get all students' record
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

	// get a student's record with the specified name
	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("WWE");
		return student;
	}
	
	// update a student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
		System.out.println("Student Name: " + studentName);
		System.out.println("Student's new name: " + student.getStudentName() + ", Student Hobby: " + student.getStudentHobby());
		
		// find the matching student record using "studentName" from the DB
		// update the matching student record with the information of student sent by the client
		// return true if update is successfully done and return false if update is not done successfully
		// return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Key1", "value1");
		
		return new ResponseEntity<>(true, httpHeaders, HttpStatus.NOT_FOUND);
	}
	
	// create a new student record
	@RequestMapping(value="/students", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student student)
	{
		System.out.println("Student Name: " + student.getStudentName() + ", Student Hobby: " + student.getStudentHobby());
		// insert the student record into the database
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(student.getStudentName()).toUri().toString());
		// location : http://localhost:8090/FirstSpringMVCProject/students/Khali
		return new ResponseEntity<>(true, httpHeaders, HttpStatus.CREATED);// 201
	}
	
	// delete a student record
	@RequestMapping(value="/students/{name}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName)
	{
		System.out.println("Student Name: " + studentName);
		// delete the student record from the database
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	// delete all student records
	@RequestMapping(value="/students", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudents()
	{
		System.out.println("Student records are deleted");
		// delete student records from the database
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}