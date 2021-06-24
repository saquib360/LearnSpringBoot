package com.example.demo.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.models.Student;

public class CacheServer {

	private static Map<Long,Student> dataCache=new HashMap<Long,Student>();
	
	public static void save(Long key,Student student) {
		if(key != null) {
			dataCache.put(key, student);
		}
	}
	
	public static Student get(Long key) {
		if(key != null && isExist(key)) {
			return dataCache.get(key);
		}
		
		return null;
	}
	
	public static boolean isExist(Long key) {
		
		return dataCache.containsKey(key);
	}
	
	public static List<Student> get() {
		
		List<Student> students = new ArrayList<>();
		
		if(dataCache.size() > 0) {
			dataCache.forEach((key, student) -> {
				students.add(student);
			});
		}
		
		return students;
	}
	
    public static void remove(Long key) {
		
		dataCache.remove(key);
	}
}
