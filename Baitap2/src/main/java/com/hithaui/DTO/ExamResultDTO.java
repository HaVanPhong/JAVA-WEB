package com.hithaui.DTO;

public class ExamResultDTO {
	private Integer studentSubjectId;
	private Integer mark;

	private Integer reMark;

	public ExamResultDTO(Integer studentSubjectId, Integer mark, Integer reMark) {
		super();
		this.studentSubjectId = studentSubjectId;
		this.mark = mark;
		this.reMark = reMark;
	}

	
	
	public ExamResultDTO() {
		super();
	}



	public Integer getStudentSubjectId() {
		return studentSubjectId;
	}

	public void setStudentSubjectId(Integer studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getReMark() {
		return reMark;
	}

	public void setReMark(Integer reMark) {
		this.reMark = reMark;
	}
	
	

}
