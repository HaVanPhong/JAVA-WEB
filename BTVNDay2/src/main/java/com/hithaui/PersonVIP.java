package com.hithaui;

public class PersonVIP {
	private int id;
	private String name;
	private String email;
	private String address;
	public PersonVIP(int id, String name, String email, String address) {
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setAddress(address);
	}
	public PersonVIP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
