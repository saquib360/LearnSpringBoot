package com.part1.part1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Hi")
public class Greeting {
	@GetMapping("")
	public String greet(){
		return "Hello";
	}
}
