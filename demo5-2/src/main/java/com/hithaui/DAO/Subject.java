package com.hithaui.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_ID")
	private Integer id;
	
	@Column(name = "name", nullable = false)
	@Nationalized
	private String name;
	
	//tạo quan hệ 2 bảng
	@ManyToOne
	@JoinColumn(name = "User_ID")
	private Student student;
	
 
//	@CreationTimestamp
	private java.sql.Timestamp createAt;
	 
	 
//	@UpdateTimestamp
	private java.sql.Timestamp updateAt;



	

}
