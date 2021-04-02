package com.hithaui.Controller;

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

import com.hithaui.DTO.StudentSubjectDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repository.StudentRepository;
import com.hithaui.Repository.StudentSubjectRepository;
import com.hithaui.Repository.SubjectRepository;
import com.hithaui.dao.Student;
import com.hithaui.dao.StudentSubject;
import com.hithaui.dao.Subject;

@RestController
@RequestMapping("/api/studentsubjects")
public class StudentSubjectController {
	
	@Autowired
	public StudentSubjectRepository studentSubjectRepository;
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public SubjectRepository subjectRepository;
	
	
	@GetMapping
	public ResponseEntity<?> getAllStudentSubject(){
		List<StudentSubject> ListstudentSubject= studentSubjectRepository.findAll();
		if (ListstudentSubject.size()==0) {
			throw new NotFoundException("Not found");
		}
		return ResponseEntity.status(200).body(ListstudentSubject);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createStudentSubject (@RequestBody StudentSubjectDTO studentSubjectDTO){
		Optional<Student> student =studentRepository.findById(studentSubjectDTO.getStudentId());
		if (!student.isPresent()) {
			throw new NotFoundException("Không tìm thấy student nào để thêm");
		}
		
		Optional<Subject> subject=subjectRepository.findById(studentSubjectDTO.getSubjectId());
		if(!subject.isPresent()) {
			throw new NotFoundException("Không tìm thấy subject nào để thêm");
		}
		Student student2=student.get();
		Subject subject2=subject.get();
		
		List<StudentSubject> studentSubject_mot = studentSubjectRepository.findByStudent(student2);
		List<StudentSubject> studentSubject_hai = studentSubjectRepository.findBySubject(subject2);
		if( (studentSubject_mot.size()!=0) && (studentSubject_hai.size()!=0) ) {
			throw new NotFoundException("Học sinh  đã được học môn này rồi");			
		}
			
		StudentSubject studentSubject =new StudentSubject(student2, subject2);
		StudentSubject studentSubject2=studentSubjectRepository.save(studentSubject);
		return ResponseEntity.status(201).body(studentSubject2);
	}
	
	@DeleteMapping("/{studentsubjectId}")
	public ResponseEntity<?> deleteStudentSubject (@PathVariable (name = "studentsubjectId") Integer studentSubjectId){
		Optional<StudentSubject> studentSubjectOptional = studentSubjectRepository.findById(studentSubjectId);
		if (!studentSubjectOptional.isPresent()) {
			throw new NotFoundException("Không tìm thấy id để xóa");
		}
		studentSubjectRepository.deleteById(studentSubjectId);
		return ResponseEntity.status(200).build();		
	}
	@PatchMapping("/{studentsubjectId}")
	public ResponseEntity<?> editStudentSubject (@PathVariable (name = "studentsubjectId") Integer studentsubjectId, 
			@RequestBody StudentSubjectDTO studentSubjectDTO	){
		
		Optional<StudentSubject> studentSubjectOptional=studentSubjectRepository.findById(studentsubjectId);
		if (!studentSubjectOptional.isPresent()) {
			throw new NotFoundException("Không tìm thấy id để chỉnh sửa");
		}
		
		Optional<Student> student =studentRepository.findById(studentSubjectDTO.getStudentId());
		if (!student.isPresent()) {
			throw new NotFoundException("Không tìm thấy student nào để thay thế");
		}
		
		Optional<Subject> subject=subjectRepository.findById(studentSubjectDTO.getSubjectId());
		if(!subject.isPresent()) {
			throw new NotFoundException("Không tìm thấy subject nào để thay thế");
		}		
		
		StudentSubject studentSubject = studentSubjectOptional.get();
		
		studentSubject.setStudent(student.get());
		studentSubject.setSubject(subject.get());
		
		StudentSubject studentSubject2=studentSubjectRepository.save(studentSubject);
		return ResponseEntity.status(200).body(studentSubject2);
	}
	

}
