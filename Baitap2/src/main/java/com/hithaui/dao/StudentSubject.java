package com.hithaui.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "StudentSubject")
public class StudentSubject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_subject_Id")
	private Integer studentSubjectId ; 
	
	
	@ManyToOne
	@JoinColumn(name = "studentId")
 	private Student student;
	
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subject subject ;
	
	@OneToMany(mappedBy = "studentSubject", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ExamResult> listExamResult;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public StudentSubject(Student student, Subject subject) {
		super();
		this.student = student;
		this.subject = subject;
	}
	public StudentSubject(Integer studentSubjectId, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.studentSubjectId = studentSubjectId;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public StudentSubject() {
	
	}
	public Integer getStudentSubjectId() {
		return studentSubjectId;
	}
	public void setStudentSubjectId(Integer studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
	}
	
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
