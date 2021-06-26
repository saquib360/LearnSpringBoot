package com.part1.part1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RequestMapping")
public class TestRequestParams {
	
	@GetMapping("blankParams")
	public String getblankParams(@RequestParam(value="name") String name) {
		return "Hi "+name;
	}
	@GetMapping("NoParamRequired")
	public String getNoParamRequired(@RequestParam(value="name", required = false) String name) {
		return "Hi "+name;
	}
	@GetMapping("DefaultParam")
	public String getDefaultParam(@RequestParam(value="name", required = false, defaultValue = "saquib") String name) {
		return "Hi "+name;
	}
	@GetMapping("MultipleParams")
	public String getMultipleParams(@RequestParam(value="name", required = false) String name, @RequestParam(value="age", required = false) int age) {
		return name+" age is "+age;
	}
	
}
