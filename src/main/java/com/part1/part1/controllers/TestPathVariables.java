package com.part1.part1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PathVaiables")
public class TestPathVariables {
	@GetMapping("")
	public String greet(){
		return "working";
	}
	//@PathVariable(name="age") int age, @PathVariable(name="name") String name  : use this if below dont work
	@GetMapping("message/{name}/{age}")
	public String showMessage(@PathVariable int age, @PathVariable String name) {
		return name+" age is "+age;
	}
}
