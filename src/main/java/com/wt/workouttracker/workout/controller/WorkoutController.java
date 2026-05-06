package com.wt.workouttracker.workout.controller;

import com.wt.workouttracker.workout.dto.WorkoutRequestDTO;
import com.wt.workouttracker.workout.dto.WorkoutResponseDTO;
import com.wt.workouttracker.workout.service.WorkoutService;
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
@RequestMapping("/workouts")
@Validated
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", useReturnTypeSchema = true)
})
@Tag(name = "Workouts", description = "API for managing workouts")
public class WorkoutController {
	private final WorkoutService workoutService;

	public WorkoutController(WorkoutService workoutService) {
		this.workoutService = workoutService;
	}

	@GetMapping
	@Operation(summary = "Get all workouts")
	@ApiResponse(responseCode = "200", content = @Content(
			array = @ArraySchema(schema = @Schema(implementation = WorkoutResponseDTO.class))))
	public ResponseEntity<List<WorkoutResponseDTO>> getWorkouts() {
		List<WorkoutResponseDTO> workoutResponseDTOS = workoutService.getWorkouts();
		return ResponseEntity.ok(workoutResponseDTOS);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get specific workout by its ID")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutResponseDTO> getWorkoutById(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		WorkoutResponseDTO workoutResponseDTO = workoutService.getWorkoutById(uuid);
		return ResponseEntity.ok(workoutResponseDTO);
	}

	@PostMapping
	@Operation(summary = "Create new workout")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	public ResponseEntity<WorkoutResponseDTO> createWorkout(
			@Valid @RequestBody WorkoutRequestDTO workoutRequestDTO) {
		WorkoutResponseDTO workoutResponseDTO = workoutService.createWorkout(workoutRequestDTO);
		return ResponseEntity.ok(workoutResponseDTO);
	}

	@PutMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout not found",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Update specific workout by its ID")
	public ResponseEntity<WorkoutResponseDTO> updateWorkout(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id,
			@Valid @RequestBody WorkoutRequestDTO workoutRequestDTO) {

		UUID uuid = UUID.fromString(id);

		WorkoutResponseDTO workoutResponseDTO = workoutService.updateWorkout(uuid, workoutRequestDTO);

		return ResponseEntity.ok(workoutResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout not found ",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Delete specific workout by its ID")
	public ResponseEntity<Void> deleteWorkout(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);
		workoutService.deleteWorkout(uuid);
		return ResponseEntity.noContent().build();
	}
}

