package com.hithaui.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error errorRespon(NotFound ex, WebRequest re) {
		return new Error(ex.getMessage(),404);
	}
	
	@ExceptionHandler(Duplicate.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Error errorResponse(Duplicate ex, WebRequest re) {
		return new Error(ex.getMessage(),400);
	}
}
