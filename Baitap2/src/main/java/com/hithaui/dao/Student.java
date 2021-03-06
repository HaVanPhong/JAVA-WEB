package com.hithaui.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="studentId", nullable =false)
	private Integer studentId;
	
	@Column(name = "studentCode", nullable = false, unique = true)
	private String studentCode;
	
	@Column(name = "fullName", nullable = false)
	@Nationalized
	private String fullName;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentSubject> listStudentSubject ;
	
	@Column (name = "phone", unique = true)
	private String phone;
	
	@CreationTimestamp 
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;

	public Student(Integer studentId, String studentCode, String fullName, String phone, Timestamp createAt,
			Timestamp updateAt) {
		super();
		this.studentId = studentId;
		this.studentCode = studentCode;
		this.fullName = fullName;
		this.phone = phone;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	public Student() {
	
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
