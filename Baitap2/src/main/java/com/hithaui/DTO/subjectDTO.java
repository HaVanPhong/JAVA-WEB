package com.hithaui.DTO;

public class subjectDTO {
	
	private String subjectCode;
	
	private String name;

	public subjectDTO(String subjectCode, String name) {
		super();
		this.subjectCode = subjectCode;
		this.name = name;
	}


	public subjectDTO() {
	
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
	
}
