package com.example.exercise3.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ UserDoesNotExistException.class })

	public ResponseEntity<Object> handleUserDoesNotExistException(Exception ex, HttpServletRequest request) {

		return ResponseEntity.badRequest().body("Processing error: " + request.getRequestURI());
	}
}
