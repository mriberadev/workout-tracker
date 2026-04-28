package com.wt.workouttracker.exercise.controller;

import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
	private final ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	@GetMapping
	public ResponseEntity<List<ExerciseResponseDTO>> getExercises() {
		List<ExerciseResponseDTO> exerciseResponseDTOS = exerciseService.getExercises();
		return ResponseEntity.ok().body(exerciseResponseDTOS);
	}
}
