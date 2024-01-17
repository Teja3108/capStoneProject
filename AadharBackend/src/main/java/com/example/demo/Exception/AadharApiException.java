package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.Exception.AdminNotFoundException;
import com.example.demo.Exception.CitizenNotFoundException;
import com.example.demo.Exception.UserNotFoundException;
@ControllerAdvice
public class AadharApiException {
	@ExceptionHandler(value=AdminNotFoundException.class)
	public ResponseEntity<Object> handleException(AdminNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=CitizenNotFoundException.class)
	public ResponseEntity<Object> handleException(CitizenNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}

