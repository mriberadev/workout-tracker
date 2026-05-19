package com.wt.workouttracker.workoutexercise.exception;

import com.wt.workouttracker.common.exception.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.wt.workouttracker.workoutexercise")
public class WorkoutExerciseExceptionHandler extends GlobalExceptionHandler {

	@ExceptionHandler(WorkoutExerciseNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleWorkoutExerciseNotFoundException(WorkoutExerciseNotFoundException e) {

		Map<String, String> errors = new HashMap<>();

		errors.put("message", "Workout exercise not found");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
}
