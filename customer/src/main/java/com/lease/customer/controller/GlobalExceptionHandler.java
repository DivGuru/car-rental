package com.lease.customer.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomerError> handleException(Exception e) {
		CustomerError error = new CustomerError(e.getMessage(),HttpStatus.UNAUTHORIZED.value(),
				LocalDateTime.now().toString());
		return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
	}
}
