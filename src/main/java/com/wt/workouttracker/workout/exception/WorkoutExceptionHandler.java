package com.wt.workouttracker.workout.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = {"com.wt.workouttracker.workout", "com.wt.workouttracker.workoutexercise"})
public class WorkoutExceptionHandler {

	@ExceptionHandler(WorkoutNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleWorkoutNotFoundException(WorkoutNotFoundException e) {

		Map<String, String> errors = new HashMap<>();

		errors.put("message", "Workout not found");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
}
