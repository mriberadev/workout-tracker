package com.wt.workouttracker.workoutexercise;

import com.wt.workouttracker.common.BaseModel;
import com.wt.workouttracker.exercise.Exercise;
import com.wt.workouttracker.workout.Workout;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "workout_exercise")
public class WorkoutExercise extends BaseModel {

	@EmbeddedId
	private WorkoutExerciseId id;

	@ManyToOne
	@MapsId("workoutId")
	@JoinColumn(name = "workout_id", insertable = false)
	private Workout workout;

	@ManyToOne
	@MapsId("exerciseId")
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;

	@NotNull
	private Integer sets;

	@NotNull
	private Integer reps;

	@NotNull
	@Column(name = "rest_seconds")
	private Integer restSeconds;

	public WorkoutExerciseId getId() {
		return id;
	}

	public void setId(WorkoutExerciseId id) {
		this.id = id;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
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
