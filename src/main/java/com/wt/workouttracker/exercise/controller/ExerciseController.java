package com.wt.workouttracker.exercise.controller;

import com.wt.workouttracker.exercise.dto.ExerciseRequestDTO;
import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exercises")
@Validated
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", useReturnTypeSchema = true)
})
@Tag(name = "Exercises", description = "API for managing exercises")
public class ExerciseController {
	private final ExerciseService exerciseService;

	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	@GetMapping
	@Operation(summary = "Get all exercises")
	@ApiResponse(responseCode = "200", content = @Content(
			array = @ArraySchema(schema = @Schema(implementation = ExerciseResponseDTO.class))))
	public ResponseEntity<List<ExerciseResponseDTO>> getExercises() {
		List<ExerciseResponseDTO> exerciseResponseDTOS = exerciseService.getExercises();
		return ResponseEntity.ok(exerciseResponseDTOS);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get specific exercise by its ID")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Exercise not found", 
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<ExerciseResponseDTO> getExerciseById(
			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		ExerciseResponseDTO exerciseResponseDTO = exerciseService.getExerciseById(uuid);
		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@PostMapping
	@Operation(summary = "Create new exercise")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	public ResponseEntity<ExerciseResponseDTO> createExercise(
			@Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO) {
		ExerciseResponseDTO exerciseResponseDTO = exerciseService.createExercise(exerciseRequestDTO);
		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@PutMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Exercise not found", 
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Update specific exercise by its ID")
	public ResponseEntity<ExerciseResponseDTO> updateExercise(
			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id,
			@Valid @RequestBody ExerciseRequestDTO exerciseRequestDTO) {

		UUID uuid = UUID.fromString(id);

		ExerciseResponseDTO exerciseResponseDTO = exerciseService.updateExercise(uuid, exerciseRequestDTO);

		return ResponseEntity.ok(exerciseResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Exercise not found ",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Delete specific exercise by its ID")
	public ResponseEntity<Void> deleteExercise(
			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		exerciseService.deleteExercise(uuid);
		return ResponseEntity.noContent().build();
	}
}
