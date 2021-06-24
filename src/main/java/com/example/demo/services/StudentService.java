package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		
		studentRepository.save(student);
	}
	public Student getById(Long id) {
		
		return studentRepository.findOneById(id);
	}
	
	public List<Student> get() {
		
		return studentRepository.findAll();
	}
	
	
	

	/*
	 * public Long saveCache(Student student) {
	 * 
	 * try { if(ObjectUtils.isEmpty(student.getId())) {
	 * student.setId(System.currentTimeMillis()); }
	 * CacheServer.save(student.getId(), student); return student.getId(); }catch
	 * (Exception e) { throw e; } }
	 * 
	 * 
	 * 
	 * public Student getByIdCache(Long id) {
	 * 
	 * try { if(!ObjectUtils.isEmpty(id)) { return CacheServer.get(id); } return
	 * null; }catch (Exception e) { throw e; } }
	 * 
	 * 
	 * 
	 * public Long removeById(Long id) {
	 * 
	 * try { if(!ObjectUtils.isEmpty(id)) { CacheServer.remove(id); } return id;
	 * }catch (Exception e) { throw e; } }
	 * 
	 * 
	 * 
	 * 
	 * public List<Student> getCache() {
	 * 
	 * try {
	 * 
	 * return CacheServer.get(); }catch (Exception e) { throw e; } }
	 */
	 
}
