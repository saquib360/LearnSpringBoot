
package com.payroll.Payroll.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.payroll.Payroll.models.EmployeeData;
import com.payroll.Payroll.services.EmployeeServices;

@RestController
@RequestMapping("EmployeePayroll")
public class EmployeePayroll {
	
	@Autowired
	EmployeeServices employeeServices;
	@PostMapping("save")
	public Map<String, Object> saveCache(@RequestParam(value="employeeImage", required = false) MultipartFile employeeImage, EmployeeData empData) {
		Map<String, Object> responseData = new HashMap<>();
		boolean isFileUploaded=employeeServices.uploadFile(employeeImage, empData);
		if(isFileUploaded)
			responseData= employeeServices.addEmployee(empData,employeeImage);
		else {
			responseData.put("msg", "Failed to upload a file");
			responseData.put("status", "f");
			responseData.put("code", 202);
		}
			
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
	
	@GetMapping("getEmployee")
	public Map<String, Object> getEmployee(String username){
		Map<String, Object> responseData = new HashMap<>();
		responseData=employeeServices.getEmployee(username);
		return responseData;
	}
	
	@GetMapping("getEmployeeImage")
	public void getEmployeeImage(String username, HttpServletRequest request, HttpServletResponse response){
		employeeServices.getEmployeeImage(username, request, response);
	}

}
