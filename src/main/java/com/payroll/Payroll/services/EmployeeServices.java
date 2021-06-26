
package com.payroll.Payroll.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.payroll.Payroll.models.EmployeeData;
import com.payroll.Payroll.storage.PayrollCache;

@Service
public class EmployeeServices {
	
	@Value("${file.upload}")
	private String defaultFilePath;
	
	public Map<String, Object> addEmployee(EmployeeData employeeData,MultipartFile employeeImage) {
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
	
	public boolean uploadFile(MultipartFile employeeImage, EmployeeData empData) {
		String filePath="";
		boolean isFileUploaded=false;
		try {
			File folder = new File(defaultFilePath + "/storage");
			boolean isDirectoryCreated=false;
			if (!folder.exists()) {
				if (folder.mkdir()) {
					isDirectoryCreated=true;
				} else {
					isDirectoryCreated=false;
				}
			}
			if(isDirectoryCreated) {
				byte[] bytes = employeeImage.getBytes();
				if(employeeImage.getOriginalFilename()!=null)
				filePath = defaultFilePath +"/"+employeeImage.getOriginalFilename();
				System.out.println(filePath);
				Path path = Paths.get(filePath);
				Files.write(path, bytes);
				isFileUploaded=true;
			}
			empData.setImagePath(filePath);
		} catch (Exception e) {
			isFileUploaded=false;
		}
	
		return isFileUploaded;
	}
	
	public Map<String, Object> getEmployee(String userName) {
		Map<String, Object> responseData = new HashMap<>();
		List<EmployeeData> employeeList = PayrollCache.getEmployeeData();
		for (EmployeeData empData : employeeList) {
			if (empData.getUserName().equals(userName)) {
				responseData.put("msg", empData.getUserName()+" User name already exist");
				responseData.put("status", "failed");
				responseData.put("code", 202);
				responseData.put("Employee", empData);
				return responseData;
			}
		}
		return responseData;
	}
	
	public void getEmployeeImage(String userName, HttpServletRequest request, HttpServletResponse response){
		File file=new File(defaultFilePath);
		List<EmployeeData> employeeList = PayrollCache.getEmployeeData();
		for (EmployeeData empData : employeeList) {
			if (empData.getUserName().equals(userName)) {
				file=new File(empData.getImagePath());
			}
		}
		if (file.exists()) {
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			// eg Content-Disposition: inline; filename="filename.pdf"
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
			response.setContentLength((int) file.length());

			InputStream inputStream;
			try {
				inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
