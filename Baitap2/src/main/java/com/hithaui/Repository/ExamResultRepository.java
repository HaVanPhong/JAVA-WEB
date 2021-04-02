package com.hithaui.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.ExamResult;
import com.hithaui.dao.StudentSubject;

@Repository
public interface ExamResultRepository extends  JpaRepository<ExamResult, Integer> {
	
	public List<ExamResult> findByStudentSubject(StudentSubject studentSubject);

}
