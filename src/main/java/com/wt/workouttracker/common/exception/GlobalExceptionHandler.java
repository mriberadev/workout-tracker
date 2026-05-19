package com.wt.workouttracker.common.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e) {

		Map<String, String> errors = new HashMap<>();

		e.getBindingResult().getFieldErrors().forEach(
				error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {

		Map<String, String> errors = new HashMap<>();

		e.getConstraintViolations().forEach(
				error -> {
					// Get param name from last element of path
					String errorParamName = null;
					for (Path.Node node : error.getPropertyPath()){
						errorParamName = node.getName();
					}
					errors.put(errorParamName, error.getMessage());
				});

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){

		Map<String, String> errors = new HashMap<>();

		switch(e.getRootCause()) {
			case DateTimeParseException dateTimeParseException -> {
				errors.put("message", "Value '" + dateTimeParseException.getParsedString()
						+ "' is not a valid date (YYYY-MM-DD) or time (hh:mm:ss) format ");
			}
			case null, default -> {
				errors.put("message", "Unknown parsing error");
			}
		}

		return ResponseEntity.badRequest().body(errors);
	}

}
