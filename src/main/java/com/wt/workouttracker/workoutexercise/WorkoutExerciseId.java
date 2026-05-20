package com.wt.workouttracker.workoutexercise;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		WorkoutExerciseId that = (WorkoutExerciseId) o;
		return Objects.equals(workoutId, that.workoutId) && Objects.equals(exerciseId, that.exerciseId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(workoutId, exerciseId);
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