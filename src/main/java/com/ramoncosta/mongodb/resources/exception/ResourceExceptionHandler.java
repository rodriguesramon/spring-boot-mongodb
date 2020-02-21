package com.ramoncosta.mongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ramoncosta.mongodb.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	HttpStatus status = HttpStatus.NOT_FOUND;
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), "Error - Not Found", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError) ;
	}	
}
