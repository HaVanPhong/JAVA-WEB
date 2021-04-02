package com.hithaui.Exception;

public class Error {
	private String message;
	private Integer status;
	public Error(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}
	public Error() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
