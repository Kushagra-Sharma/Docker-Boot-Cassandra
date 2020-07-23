package com.example.docker.springcassandradockerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.docker.springcassandradockerdemo.ResourceNotFoundException;
import com.example.docker.springcassandradockerdemo.entity.Student;
import com.example.docker.springcassandradockerdemo.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
		
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Integer studentId, @RequestBody Student student) {
		Student studentDetails = studentRepository.findById(studentId).orElseThrow(
		() -> new ResourceNotFoundException("Student not found"));
		
		studentDetails.setName(student.getName());
		final Student updatedStudent = studentRepository.save(studentDetails);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable(value="id") Integer studentId, @RequestBody Student student) {
		Student studentDetails = studentRepository.findById(studentId).orElseThrow(
				() -> new ResourceNotFoundException("Student not found"));
		studentRepository.delete(studentDetails);
		return ResponseEntity.ok().build();
	}
	
	
}
