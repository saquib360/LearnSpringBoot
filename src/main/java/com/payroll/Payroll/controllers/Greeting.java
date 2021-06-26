package com.payroll.Payroll.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
	@GetMapping("Hi")
	public String greet() {
		return "hello";
	}
}
