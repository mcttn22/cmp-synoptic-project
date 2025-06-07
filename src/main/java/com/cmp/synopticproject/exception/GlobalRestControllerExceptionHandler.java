package com.cmp.synopticproject.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Class to handle custom exceptions thrown anywhere in application.
 */
@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

	/**
	 * Handle ResidentAlreadyExists exception.
	 * @return a ResponseEntity object.
	 */
	@ExceptionHandler(ResidentAlreadyExistsException.class)
	ResponseEntity<HashMap<String, String>> residentAlreadyExistsHandler (ResidentAlreadyExistsException e) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		responseData.put("message", e.getMessage());
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle ResidentAuthenticationFailure exception.
	 * @return a ResponseEntity object.
	 */
	@ExceptionHandler(ResidentAuthenticationFailureException.class)
	ResponseEntity<HashMap<String, String>> residentAuthenticationFailureHandler (ResidentAuthenticationFailureException e) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		responseData.put("message", e.getMessage());
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle ResidentDoesNotExist exception.
	 * @return a ResponseEntity object.
	 */
	@ExceptionHandler(ResidentDoesNotExistException.class)
	ResponseEntity<HashMap<String, String>> residentDoestNotExistHandler (ResidentDoesNotExistException e) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		responseData.put("message", e.getMessage());
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handle ToiletDoesNotExistException exception.
	 * @return a ResponseEntity object.
	 */
	@ExceptionHandler(ToiletDoesNotExistException.class)
	ResponseEntity<HashMap<String, String>> toiletDoesNotExistHandler (ToiletDoesNotExistException e) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		responseData.put("message", e.getMessage());
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
	}
}

