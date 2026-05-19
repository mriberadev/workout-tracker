package com.wt.workouttracker.workoutdate.exception;

import com.wt.workouttracker.common.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.wt.workouttracker.workoutdate")
public class WorkoutDateExceptionHandler extends GlobalExceptionHandler {

	@ExceptionHandler(WorkoutDateNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleWorkoutDateNotFoundException(WorkoutDateNotFoundException e) {

		Map<String, String> errors = new HashMap<>();

		errors.put("message", "Workout date not found");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
}
