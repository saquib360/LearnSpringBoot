
package com.payroll.Payroll.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.Payroll.models.EmployeeData;
import com.payroll.Payroll.services.EmployeeServices;

@RestController
@RequestMapping("EmployeePayroll")
public class EmployeePayroll {
	
	@Autowired
	EmployeeServices employeeServices;
	@PostMapping("save")
	public Map<String, Object> saveCache(EmployeeData empData) {
		Map<String, Object> responseData = new HashMap<>();
		responseData= employeeServices.addEmployee(empData);
		return responseData;
	}
	@GetMapping("getList")
	public Map<String, Object> getEmployeeList(){
		Map<String, Object> responseData = new HashMap<>();
		
		responseData.put("msg", "Employee fetched successfully.");
		responseData.put("status", "success");
		responseData.put("code", 200);
		responseData.put("Employee List", employeeServices.getEmployeeList());
		return responseData;
	}

}
