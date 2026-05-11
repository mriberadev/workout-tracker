package com.wt.workouttracker.workoutexercise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class WorkoutExerciseId implements Serializable {

	@Column(name = "workout_id")
	private UUID workoutId;

	@Column(name = "exercise_id")
	private UUID exerciseId;

	public WorkoutExerciseId() {
	}

	public WorkoutExerciseId(UUID workoutId, UUID exerciseId) {
		this.workoutId = workoutId;
		this.exerciseId = exerciseId;
	}

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
}