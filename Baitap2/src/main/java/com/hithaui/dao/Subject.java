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
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subjectId")
	private Integer subjectId;
	
	@Column(name = "subject_code", unique = true)
	private String subjectCode;
	
	@Column(name = "subject_name")
	@Nationalized
	private String name;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StudentSubject> listStudentSubject;
	
	
	@CreationTimestamp
	private Timestamp createAt;
	@UpdateTimestamp
	private Timestamp updateAt;
	public Subject(Integer subjectId, String subjectCode, String name, Timestamp createAt, Timestamp updateAt) {
		super();
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.name = name;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	public Subject() {

	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
