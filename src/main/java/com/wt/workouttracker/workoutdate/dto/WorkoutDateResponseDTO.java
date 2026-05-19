package com.wt.workouttracker.workoutdate.dto;

public class WorkoutDateResponseDTO {

	private String id;
	private String workoutId;
	private String date;
	private String time;
	private String lastModificationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(String lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
}
