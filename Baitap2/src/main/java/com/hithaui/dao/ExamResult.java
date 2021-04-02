package com.hithaui.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ExamResults")
public class ExamResult {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "examResultId")
	private Integer examResultId;
	
	@ManyToOne
	@JoinColumn(name = "student_subject_Id")
	private StudentSubject studentSubject;
	
	@Column(name = "mark")
	private Integer mark;
	
	@Column(name = "remark")
	private Integer reMark;
	
	@CreationTimestamp
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;

	public ExamResult(StudentSubject studentSubject, Integer mark, Integer reMark) {
		super();
		this.studentSubject = studentSubject;
		this.mark = mark;
		this.reMark = reMark;
	
	}
	public ExamResult() {
		
	}
	
	
	
	public Integer getExamResultId() {
		return examResultId;
	}
	public void setExamResultId(Integer examResultId) {
		this.examResultId = examResultId;
	}
	public StudentSubject getStudentSubject() {
		return studentSubject;
	}
	public void setStudentSubject(StudentSubject studentSubject) {
		this.studentSubject = studentSubject;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public Integer getReMark() {
		return reMark;
	}
	public void setReMark(Integer reMark) {
		this.reMark = reMark;
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
