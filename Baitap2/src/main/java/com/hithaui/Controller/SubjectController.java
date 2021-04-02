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

import com.hithaui.DTO.subjectDTO;
import com.hithaui.Exception.NotFoundException;
import com.hithaui.Repository.SubjectRepository;
import com.hithaui.dao.Subject;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
	
	
	
	@Autowired
	public SubjectRepository subjectRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllSubject(){
		List<Subject> list = subjectRepository.findAll();
		if (list.size()==0) {
			throw new NotFoundException("Không tìm thấy môn học nào");
		}
		return ResponseEntity.status(200).body(list);
	}
	
	@PostMapping 
	public  ResponseEntity<?> createSubject(@RequestBody subjectDTO subjectDTO){
		Subject subject=subjectRepository.findBySubjectCode(subjectDTO.getSubjectCode());
		if (subject!=null) {
			throw new NotFoundException("Mã môn học đã tồn tại");
		}
		subject=new Subject();
		subject.setSubjectCode(subjectDTO.getSubjectCode());
		subject.setName(subjectDTO.getName());
		
		Subject subject2=subjectRepository.save(subject);
		
		return ResponseEntity.status(201).body(subject2);
	}
	
	@DeleteMapping("/{subjectID}")
	public ResponseEntity<?> deleteSubjectByID (@PathVariable(name = "subjectID") Integer subjectId ){
		Optional<Subject> subject=subjectRepository.findById(subjectId);
		if (!subject.isPresent()) {
			throw new NotFoundException("Không tồn tại id để xóa");
		}
		subjectRepository.deleteById(subjectId);
		return ResponseEntity.status(200).build();
	}
	
	@PatchMapping("/{subjectId}")
	public ResponseEntity<?> editSubjectByID(@PathVariable (name ="subjectId" ) Integer subjectId, @RequestBody subjectDTO subjectDTO){
		Optional<Subject> subject = subjectRepository.findById(subjectId);
		if (subject==null) {
			throw new NotFoundException("Không tìm thấy id để chỉnh sửa");
		}
		Subject subject2=subject.get();
		if (subjectDTO.getSubjectCode()!=null)
			subject2.setSubjectCode(subjectDTO.getSubjectCode());
		if (subjectDTO.getName()!=null)
			subject2.setName(subjectDTO.getName());
		
		Subject subject3 = subjectRepository.save(subject2);
		
		return ResponseEntity.status(200).body(subject3);
	}
	
}
