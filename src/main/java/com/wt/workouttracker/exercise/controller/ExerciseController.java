package com.wt.workouttracker.exercise.controller;

import com.wt.workouttracker.exercise.dto.ExerciseRequestDTO;
import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.dto.validators.CreateExerciseValidationGroup;
import com.wt.workouttracker.exercise.service.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exercises")
@Validated
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

	@GetMapping("/{id}")
	public ResponseEntity<ExerciseResponseDTO> getExerciseById(
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		ExerciseResponseDTO exerciseResponseDTO = exerciseService.getExerciseById(uuid);
		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@PostMapping
	public ResponseEntity<ExerciseResponseDTO> createExercise(
			@Validated({CreateExerciseValidationGroup.class}) @RequestBody ExerciseRequestDTO exerciseRequestDTO) {
		ExerciseResponseDTO exerciseResponseDTO = exerciseService.createExercise(exerciseRequestDTO);
		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExerciseResponseDTO> updateExercise(
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id,
			@Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO) {

		UUID uuid = UUID.fromString(id);

		ExerciseResponseDTO exerciseResponseDTO = exerciseService.updateExercise(uuid, exerciseRequestDTO);

		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExercise(
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		exerciseService.deleteExercise(uuid);
		return ResponseEntity.ok().build();
	}
}
