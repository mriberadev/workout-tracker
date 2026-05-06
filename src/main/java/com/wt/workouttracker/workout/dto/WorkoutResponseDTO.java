package com.wt.workouttracker.workout.dto;

public class WorkoutResponseDTO {
	private String id;
	private String name;
	private String last_modification_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_modification_date() {
		return last_modification_date;
	}

	public void setLast_modification_date(String last_modification_date) {
		this.last_modification_date = last_modification_date;
	}
}
