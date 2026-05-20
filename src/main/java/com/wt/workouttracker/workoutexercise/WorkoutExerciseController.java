package com.wt.workouttracker.workoutexercise;

import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseRequestDTO;
import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseResponseDTO;
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
@RequestMapping("/workout-exercises")
@Validated
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", useReturnTypeSchema = true)
})
@Tag(name = "Workout Exercises", description = "API for managing exercises in a workout")
public class WorkoutExerciseController {
	private final WorkoutExerciseService workoutExerciseService;

	public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
		this.workoutExerciseService = workoutExerciseService;
	}

	@GetMapping
	@Operation(summary = "Get all workout exercises")
	@ApiResponse(responseCode = "200", content = @Content(
			array = @ArraySchema(schema = @Schema(implementation = WorkoutExerciseResponseDTO.class))))
	public ResponseEntity<List<WorkoutExerciseResponseDTO>> getWorkouts() {
		List<WorkoutExerciseResponseDTO> workoutExerciseResponseDTOS = workoutExerciseService.getWorkoutExercises();
		return ResponseEntity.ok(workoutExerciseResponseDTOS);
	}

	@GetMapping("/{workoutId}/{exerciseId}")
	@Operation(summary = "Get specific workout exercise by its workout ID and exercise ID")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout exercise not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutExerciseResponseDTO> getWorkoutExerciseByWorkoutIdAndExerciseId(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String workoutId,

			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String exerciseId
	) {

		UUID workoutUuid = UUID.fromString(workoutId);
		UUID exerciseUuid = UUID.fromString(exerciseId);
		WorkoutExerciseResponseDTO workoutExerciseResponseDTO =
				workoutExerciseService.getWorkoutExerciseByWorkoutIdAndExerciseId(workoutUuid, exerciseUuid);
		return ResponseEntity.ok(workoutExerciseResponseDTO);
	}

	@PostMapping
	@Operation(summary = "Create new workout exercise")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout or exercise not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutExerciseResponseDTO> createWorkoutExercise(
			@Valid @RequestBody WorkoutExerciseRequestDTO workoutExerciseRequestDTO) {
		WorkoutExerciseResponseDTO workoutExerciseResponseDTO = workoutExerciseService.createWorkoutExercise(workoutExerciseRequestDTO);
		return ResponseEntity.ok(workoutExerciseResponseDTO);
	}

	@PutMapping("/{workoutId}/{exerciseId}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout exercise not found",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Update specific workout exercise by its workout ID and exercise ID")
	public ResponseEntity<WorkoutExerciseResponseDTO> updateWorkoutExercise(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String workoutId,

			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String exerciseId,

			@Valid @RequestBody WorkoutExerciseRequestDTO workoutExerciseRequestDTO
	) {

		UUID workoutUuid = UUID.fromString(workoutId);
		UUID exerciseUuid = UUID.fromString(exerciseId);

		WorkoutExerciseResponseDTO workoutExerciseResponseDTO =
				workoutExerciseService.updateWorkoutExercise(workoutUuid, exerciseUuid, workoutExerciseRequestDTO);

		return ResponseEntity.ok(workoutExerciseResponseDTO);
	}

	@DeleteMapping("/{workoutId}/{exerciseId}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout exercise not found ",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Delete specific workout exercise by its workout ID and exercise ID")
	public ResponseEntity<Void> deleteWorkout(
			@Parameter(description = "Workout UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String workoutId,

			@Parameter(description = "Exercise UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String exerciseId
	) {

		UUID workoutUuid = UUID.fromString(workoutId);
		UUID exerciseUuid = UUID.fromString(exerciseId);

		workoutExerciseService.deleteWorkoutExercise(workoutUuid, exerciseUuid);
		return ResponseEntity.noContent().build();
	}
}

