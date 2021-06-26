
package com.payroll.Payroll.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.payroll.Payroll.models.EmployeeData;

public class PayrollCache {
	private static Map<Long, EmployeeData> payrollCache = new HashMap<Long, EmployeeData>();

	public static List<EmployeeData> getEmployeeData() {

		List<EmployeeData> employeeList = new ArrayList<EmployeeData>();
		if (payrollCache.size() > 0) {
			payrollCache.forEach((id, empData) -> {
				employeeList.add(empData);
			});
		}
		return employeeList;
	}

	public static void saveEmployee(long employeeId, EmployeeData employeeData) {
		payrollCache.put(employeeId, employeeData);
	}
}
