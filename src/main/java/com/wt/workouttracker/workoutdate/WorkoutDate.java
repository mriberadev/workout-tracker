package com.wt.workouttracker.workoutdate;

import com.wt.workouttracker.common.BaseModel;
import com.wt.workouttracker.workout.Workout;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "workout_date")
public class WorkoutDate extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "workout_id", updatable = false)
	private Workout workout;

	@NotNull
	@Column(name = "workout_date")
	private LocalDate date;

	@NotNull
	@Column(name = "workout_time")
	private LocalTime time;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
}
