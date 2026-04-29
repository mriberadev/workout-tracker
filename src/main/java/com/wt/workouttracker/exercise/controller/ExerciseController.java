package com.wt.workouttracker.exercise.controller;

import com.wt.workouttracker.exercise.dto.ExerciseRequestDTO;
import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.dto.validators.CreateExerciseValidationGroup;
import com.wt.workouttracker.exercise.service.ExerciseService;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
		return ResponseEntity.ok(exerciseResponseDTOS);
	}

	@PostMapping
	public ResponseEntity<ExerciseResponseDTO> createExercise(
			@Validated({CreateExerciseValidationGroup.class}) @RequestBody ExerciseRequestDTO exerciseRequestDTO) {
		ExerciseResponseDTO exerciseResponseDTO = exerciseService.createExercise(exerciseRequestDTO);
		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExerciseResponseDTO> updateExercise(
			@PathVariable String id,
			@Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO) {

		ExerciseResponseDTO exerciseResponseDTO = exerciseService.updateExercise(id, exerciseRequestDTO);

		return ResponseEntity.ok(exerciseResponseDTO);
	}
}
