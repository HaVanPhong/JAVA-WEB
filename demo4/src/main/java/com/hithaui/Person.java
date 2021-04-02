package com.hithaui;

public class Person {
	private String nameString;
	private Integer ageInteger;
	public Person(String nameString, Integer ageInteger) {
		this.nameString = nameString;
		this.ageInteger = ageInteger;
	}
	public Person() {
	
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Integer getAgeInteger() {
		return ageInteger;
	}
	public void setAgeInteger(Integer ageInteger) {
		this.ageInteger = ageInteger;
	}
	
	
	
}
