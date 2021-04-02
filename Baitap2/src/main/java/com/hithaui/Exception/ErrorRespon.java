package com.hithaui.Exception;

public class ErrorRespon {
	
	private Integer status;
	
	private String message;

	public ErrorRespon(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ErrorRespon() {
		
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
