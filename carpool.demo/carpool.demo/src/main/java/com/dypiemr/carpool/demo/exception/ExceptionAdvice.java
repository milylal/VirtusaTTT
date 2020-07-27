package com.dypiemr.carpool.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<CustomErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		CustomErrorResponse exceptionResponse = new CustomErrorResponse(new Date(), ex.getMessage(),
			        request.getDescription(false));
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(NotFoundException e,WebRequest request) {
		CustomErrorResponse exceptionResponse = new CustomErrorResponse(new Date(), e.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}	

}
