package com.doctor.appointment.scheduling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppointmentExceptionController {
	@ExceptionHandler(value = EntityNullException.class)
	   public ResponseEntity<Object> exception(EntityNullException exception) {
	      return new ResponseEntity<>("Provided entity is NULL or empty", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ValidationException.class)
	   public ResponseEntity<Object> exception(ValidationException exception) {
	      return new ResponseEntity<>("Fields  are empty or invalid", HttpStatus.NOT_FOUND);
	}
}
