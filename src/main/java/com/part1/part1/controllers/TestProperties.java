package com.part1.part1.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RequestProperties")
public class TestProperties {
	
	@Value("${env}")
	private String env;
	
	@Value("application")
	private String defaultValue;
	
	@Value("false")
	private boolean defautFfalse;

	@Value("10")
	private int defaultInt;
	
	@Value("${message:message not found}")
	private String message;
	
	@Value("${java.home}")
	private String JavaHomePath;
	
	@Value("${listOfValues}")
	private String[] valuesArray;
	
	@Value("#{${valuesMap}}")
	private Map<String, Integer> valuesMap;
	
	@Value("#{${valuesMap}.key1}")
	private Integer mapkek1;
	
	@GetMapping("/")
	public String entryPoint(){
		return "application up and running and message ="+env;
	}
	
	@GetMapping("/app")
	public String info(){
		System.out.println(defaultValue);
		System.out.println(defautFfalse);
		System.out.println(defaultInt);
		System.out.println(message);
		System.out.println(JavaHomePath);
		System.out.println(valuesArray);
		System.out.println(valuesMap);
		System.out.println(mapkek1);
		return "application up and running";
	}
	
	

}
