package com.hithaui.DAO;

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

@Entity
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private Integer id;
	
	@Column(name = "full_name", nullable = false)
	@Nationalized
	private String fullName;
	
	@Column(name = "phone",nullable = false,  unique = true)
	private String phone;
	
	@OneToMany(mappedBy = "Students", cascade = CascadeType.ALL)
	private List<Subject> listSubject;
	
	@CreationTimestamp
	private java.sql.Timestamp createAt;

	 
	@UpdateTimestamp
	private java.sql.Timestamp updateAt;

	public Student(Integer id, String fullName, String phone, java.sql.Timestamp createAt, java.sql.Timestamp updateAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Student() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public java.sql.Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(java.sql.Timestamp createAt) {
		this.createAt = createAt;
	}

	public java.sql.Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(java.sql.Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
	
}
