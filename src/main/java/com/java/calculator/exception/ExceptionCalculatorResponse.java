package com.java.calculator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionCalculatorResponse extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionCalculatorResponse.class);


	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> runtimeExceptionHandler(RuntimeException e){
		logger.info("Runtime exception handler calculator", e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleExceptionResponse(NullPointerException e){
		logger.info("NullPointer exception handler calculator", e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatExceptionResponse(NumberFormatException e){
		logger.info("Number format exception handler calculator", e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleExceptionResponse(Exception e){
		logger.info("Exception handler calculator", e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}