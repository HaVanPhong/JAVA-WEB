package com.hithaui.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DTO.StudentDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repository.StudentRepository;
import com.hithaui.dao.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	public  StudentRepository studentRepository;
	
	List<Student> listStudent =new ArrayList<Student>();

	@GetMapping
	public ResponseEntity<?> getAllStudent (){
		listStudent=studentRepository.findAll();
		if (listStudent.size()==0) {
			throw new NotFoundException("NO STUDENTS EXISTS");
		}
		return ResponseEntity.status(200).body(listStudent);		
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentByID (@PathVariable (name = "studentId") Integer studentId){
		Optional<Student> student=studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new NotFoundException("STUDENT'S ID WAS NOT FOUND");
		}
		return ResponseEntity.status(200).body(student);		
	}
	
	@PostMapping
	public ResponseEntity<?> createAStudent(@RequestBody StudentDTO studentDTO){
		Student student=studentRepository.findByStudentCode(studentDTO.getStudentCode());
		if (student!=null) {
			throw new NotFoundException("Student's Code already exists");
		}
		student=studentRepository.findByPhone(studentDTO.getPhone());
		if (student!=null) {
			throw new NotFoundException("Student's Phone number already exists");
		}
		
		student=new Student();
		student.setStudentCode(studentDTO.getStudentCode());
		student.setFullName(studentDTO.getFullName());
		student.setPhone(studentDTO.getPhone());
		
		Student student2 = studentRepository.save(student);
		return ResponseEntity.status(201).body(student2);
		
	}
	@PatchMapping("/{studentId}")
	public ResponseEntity<?> editStudentByID (@PathVariable (name = "studentId") Integer studentId, 
			@RequestBody StudentDTO studentDTO){
		Optional<Student> studentOptional =studentRepository.findById(studentId);
		if (!studentOptional.isPresent()) {
			throw new NotFoundException("DOES NOT FOUND STUDENT'S ID TO EDIT");
		}
		Student  student1=studentRepository.findByPhone(studentDTO.getPhone());
		if (student1!=null) {
			throw new NotFoundException("Student's Phone number already exists");
		}
		
		
		Student student=studentOptional.get();
		if (studentDTO.getStudentCode()!=null)
			student.setStudentCode(studentDTO.getStudentCode());
		
		if (studentDTO.getFullName()!=null)
			student.setFullName(studentDTO.getFullName());
		
		if (studentDTO.getPhone()!=null)
			student.setPhone(studentDTO.getPhone());
		
		Student student2=studentRepository.save(student);
		
		return ResponseEntity.status(200).body(student2);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deletStudentByID(@PathVariable (name = "studentId") Integer studentId){
		Optional<Student> student=studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new NotFoundException("STUDENT'S ID WAS NOT FOUND TO DELETE");
		}
		studentRepository.deleteById(studentId);
		return ResponseEntity.status(200).build();	
		
	}
	
	
	
}
