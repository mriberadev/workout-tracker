package com.wt.workouttracker.workoutdate;

import com.wt.workouttracker.workoutdate.dto.WorkoutDateRequestDTO;
import com.wt.workouttracker.workoutdate.dto.WorkoutDateResponseDTO;
import com.wt.workouttracker.workoutdate.dto.validation.CreateWorkoutDateValidationGroup;
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
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workout-dates")
@Validated
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", useReturnTypeSchema = true)
})
@Tag(name = "Workout Dates", description = "API for managing workout dates")
public class WorkoutDateController {

	private final WorkoutDateService workoutDateService;

	public WorkoutDateController(WorkoutDateService workoutDateService) {
		this.workoutDateService = workoutDateService;
	}

	@GetMapping
	@Operation(summary = "Get all workout dates")
	@ApiResponse(responseCode = "200", content = @Content(
			array = @ArraySchema(schema = @Schema(implementation = WorkoutDateResponseDTO.class))))
	public ResponseEntity<List<WorkoutDateResponseDTO>> getWorkoutDates(){

		List<WorkoutDateResponseDTO> workoutDateResponseDTOS = workoutDateService.getWorkoutDates();

		return ResponseEntity.ok(workoutDateResponseDTOS);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get specific workout date by its ID")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout date not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutDateResponseDTO> getWorkoutDateById(
			@Parameter(description = "Workout date UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);

		WorkoutDateResponseDTO workoutDateResponseDTO = workoutDateService.getWorkoutDateById(uuid);

		return ResponseEntity.ok(workoutDateResponseDTO);
	}

	@PostMapping
	@Operation(summary = "Create new workout date")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout for this date not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutDateResponseDTO> createWorkoutDate(
			@Validated({Default.class, CreateWorkoutDateValidationGroup.class}) @RequestBody WorkoutDateRequestDTO workoutDateRequestDTO) {

		WorkoutDateResponseDTO workoutDateResponseDTO = workoutDateService.createWorkoutDate(workoutDateRequestDTO);

		return ResponseEntity.ok(workoutDateResponseDTO);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update specific workout date by its ID")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout or its date not found",
			content = @Content(schema = @Schema(hidden = true)))
	public ResponseEntity<WorkoutDateResponseDTO> updateWorkoutDate(
			@Parameter(description = "Workout date UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id,
			@Valid @RequestBody WorkoutDateRequestDTO workoutDateRequestDTO) {

		UUID uuid = UUID.fromString(id);

		WorkoutDateResponseDTO workoutDateResponseDTO = workoutDateService.updateWorkoutDate(uuid, workoutDateRequestDTO);

		return ResponseEntity.ok(workoutDateResponseDTO);
	}

	@DeleteMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "One or more request parameters are invalid",
			content = @Content(examples = @ExampleObject(value = "{\"parameter\": \"error message\"}")))
	@ApiResponse(responseCode = "404", description = "Workout date not found ",
			content = @Content(schema = @Schema(hidden = true)))
	@Operation(summary = "Delete specific workout date by its ID")
	public ResponseEntity<WorkoutDateResponseDTO> deleteWorkoutDate(
			@Parameter(description = "Workout date UUID")
			@PathVariable
			@org.hibernate.validator.constraints.UUID
			String id) {

		UUID uuid = UUID.fromString(id);

		workoutDateService.deleteWorkoutDate(uuid);

		return ResponseEntity.noContent().build();
	}
}
