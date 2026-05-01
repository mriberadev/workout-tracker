package com.wt.workouttracker.exercise.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

	@ExceptionHandler(ExerciseNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleExerciseNotFoundException(ExerciseNotFoundException e) {

		Map<String, String> errors = new HashMap<>();

		log.warn("Exercise not found {}", e.getMessage());
		errors.put("message", "exercise not found");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
}
