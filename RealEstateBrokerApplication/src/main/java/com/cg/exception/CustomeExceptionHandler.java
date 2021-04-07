package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomeExceptionHandler {
	@ExceptionHandler(BrokerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBrokerNotFoundException(BrokerNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
	@ExceptionHandler(PropertyNotFoundException.class)
	public ResponseEntity<ErrorMessage> handlePropertyNotFoundException( PropertyNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
