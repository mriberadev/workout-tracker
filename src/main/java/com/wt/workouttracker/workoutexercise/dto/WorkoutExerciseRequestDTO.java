package com.wt.workouttracker.workoutexercise.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class WorkoutExerciseRequestDTO {


	@NotNull
	private UUID workoutId;

	@NotNull
	private UUID exerciseId;

	@NotNull
	@Min(value = 1)
	private Integer sets;

	@NotNull
	@Min(value = 1)
	private Integer reps;

	@NotNull
	@Min(value = 0)
	private Integer restSeconds;

	public UUID getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(UUID workoutId) {
		this.workoutId = workoutId;
	}

	public UUID getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(UUID exerciseId) {
		this.exerciseId = exerciseId;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getRestSeconds() {
		return restSeconds;
	}

	public void setRestSeconds(Integer restSeconds) {
		this.restSeconds = restSeconds;
	}

}
