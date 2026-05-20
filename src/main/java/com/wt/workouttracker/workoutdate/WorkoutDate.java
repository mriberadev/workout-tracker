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
	@Column(name = "scheduled_date")
	private LocalDate scheduledDate;

	@NotNull
	@Column(name = "scheduled_time")
	private LocalTime scheduledTime;

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

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate date) {
		this.scheduledDate = date;
	}

	public LocalTime getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(LocalTime time) {
		this.scheduledTime = time;
	}
}
