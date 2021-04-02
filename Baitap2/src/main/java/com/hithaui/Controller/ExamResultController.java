package com.hithaui.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hithaui.DTO.ExamResultDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repository.ExamResultRepository;
import com.hithaui.Repository.StudentSubjectRepository;
import com.hithaui.dao.ExamResult;
import com.hithaui.dao.StudentSubject;

@RestController
@RequestMapping("/api/examResults")
public class ExamResultController {
	
	@Autowired
	public ExamResultRepository examResultRepository;
	
	@Autowired
	public StudentSubjectRepository studentSubjectRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllExamResult(){
		List<ExamResult> listExamResults = examResultRepository.findAll();
		if (listExamResults.size()==0) {
			throw new NotFoundException("Exam's Result is Empty");
		}
		return ResponseEntity.status(200).body(listExamResults);		
	}
	
	@PostMapping
	public ResponseEntity<?> creatExamResult (@RequestBody ExamResultDTO examResultDTO){
		Optional<StudentSubject> studentSubjectOptional=studentSubjectRepository.findById(examResultDTO.getStudentSubjectId());
		if (!studentSubjectOptional.isPresent()) {
			throw new NotFoundException("Student_Subject_Id không tồn tại");
		}
				
		StudentSubject studentSubject=studentSubjectOptional.get();
		
		List<ExamResult> examResult = examResultRepository.findByStudentSubject(studentSubject);
		
		if (examResult.size()!=0) {
			throw new NotFoundException("Student_Subject này đã có kết quả");
		}
		
		ExamResult examResult2 = new ExamResult(studentSubject, examResultDTO.getMark(), examResultDTO.getReMark());
		
		ExamResult examResult3=examResultRepository.save(examResult2);
		
		return ResponseEntity.status(201).body(examResult3);
		
	}

}
