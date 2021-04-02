package com.hithaui.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;
import org.springframework.data.domain.ExampleMatcher.PropertyValueTransformer;

@Entity
@Table(name = "Accounts")
public class AccountDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Account_ID")
	private Long id; //BIGINT
	
	@Column(name = "USER_NAME", nullable = false, unique = true)
	@Nationalized
	private String userName;
	
	@Column(name = "PASS_WORD", nullable = false)
	@Nationalized
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountDAO(Long id, String userName, String password) {
	
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public AccountDAO() {
		
	}
	
	
}
