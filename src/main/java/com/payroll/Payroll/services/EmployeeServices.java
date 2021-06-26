
package com.payroll.Payroll.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.payroll.Payroll.models.EmployeeData;
import com.payroll.Payroll.storage.PayrollCache;

@Service
public class EmployeeServices {

	public Map<String, Object> addEmployee(EmployeeData employeeData) {
		Map<String, Object> responseData = new HashMap<>();
		try {
			if (ObjectUtils.isEmpty(employeeData.getId())) {
				employeeData.setId(System.currentTimeMillis());
			}
			List<EmployeeData> employeeList = PayrollCache.getEmployeeData();
			for (EmployeeData empData : employeeList) {
				if (empData.getUserName().equals(employeeData.getUserName())) {
					responseData.put("msg", empData.getUserName()+" User name already exist");
					responseData.put("status", "failed");
					responseData.put("code", 202);	
					return responseData;
				}
			}

			PayrollCache.saveEmployee(employeeData.getId(), employeeData);
			responseData.put("msg", "Employee saved successfully.");
			responseData.put("status", "success");
			responseData.put("code", 200);
		} catch (Exception e) {
			responseData.put("msg", "Failed to save Employee");
			responseData.put("status", "failed");
			responseData.put("code", 202);
		}
		return responseData;
	}

	public List<EmployeeData> getEmployeeList() {
		return PayrollCache.getEmployeeData();
	}

}
