package com.hithaui.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.dao.Student;
import com.hithaui.dao.StudentSubject;
import com.hithaui.dao.Subject;

@Repository
public interface StudentSubjectRepository  extends JpaRepository<StudentSubject, Integer>{

	public List<StudentSubject> findByStudent(Student student);
	public List<StudentSubject> findBySubject(Subject subject);
}
