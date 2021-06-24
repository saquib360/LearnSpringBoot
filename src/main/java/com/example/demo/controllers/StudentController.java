package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("")
	private Map<String, Object> studentDetails(@RequestBody Student student) {
		
		Map<String, Object> responseData = new HashMap<>();
		String userName=student.getUserName();
		List<Student> allstudent=studentService.get();
		allstudent.forEach((Student)->{
			if(userName.equals(Student.getUserName())) {
				responseData.put("msg", userName+" : User Name already Exist");
				responseData.put("status", "failed");
				responseData.put("code", 409);
				student.setStatus(0);
			}
		});
		if(student.getStatus()==1){
			studentService.save(student);
			responseData.put("msg", "Student saved successfully.");
			responseData.put("status", "success");
			responseData.put("code", 200);
		}
		return responseData;
	}
	
	@GetMapping("by-id/{id}")
	private Map<String, Object> getStudentById(@PathVariable("id") Long id) {
		
		Map<String, Object> responseData = new HashMap<>();
		
		responseData.put("status", "success");
		responseData.put("msg", "Student fetched successfully.");
		responseData.put("code", 200);
		responseData.put("data", studentService.getById(id));
		
		return responseData;
	}
	
	@GetMapping("")
	private Map<String, Object> get() {
		
		Map<String, Object> responseData = new HashMap<>();
		
		responseData.put("status", "success");
		responseData.put("msg", "Student fetched successfully.");
		responseData.put("code", 200);
		responseData.put("data", studentService.get());
		
		return responseData;
	}

}
