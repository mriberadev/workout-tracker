package com.wt.workouttracker.workout.model;

import com.wt.workouttracker.common.model.BaseModel;
import com.wt.workouttracker.workoutdate.model.WorkoutDate;
import com.wt.workouttracker.workoutexercise.model.WorkoutExercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Workout extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotEmpty
	private String name;

	@OneToMany(mappedBy = "workout", cascade = {CascadeType.REMOVE})
	private List<WorkoutExercise> workoutExerciseList = new ArrayList<>();

	@OneToMany(mappedBy = "workout", cascade = {CascadeType.REMOVE})
	private List<WorkoutDate> workoutDateList = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkoutExercise> getWorkoutExerciseList() {
		return workoutExerciseList;
	}

	public void setWorkoutExerciseList(List<WorkoutExercise> workoutExerciseList) {
		this.workoutExerciseList = workoutExerciseList;
	}
}
