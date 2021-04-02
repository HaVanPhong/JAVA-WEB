package com.hithaui.DTO;

public class StudentSubjectDTO {
	private Integer studentId;
	private Integer subjectId;
	public StudentSubjectDTO(Integer studentId, Integer subjectId) {
		super();
		this.studentId = studentId;
		this.subjectId = subjectId;
	}
	 
	public StudentSubjectDTO() {
		super();
		
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	 
	


}
