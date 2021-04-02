package com.hithaui;

public class ErrorResponse {
	private Integer status;
	private String message;
	public ErrorResponse(Integer status , String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ErrorResponse() {
	
	}
	public Integer getInteger() {
		return status;
	}
	public void setInteger(Integer integer) {
		this.status = integer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
