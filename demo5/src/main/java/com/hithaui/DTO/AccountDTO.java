package com.hithaui.DTO;

public class AccountDTO {
	private String userName;
	private String password;
	public AccountDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public AccountDTO() {
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
	

}
