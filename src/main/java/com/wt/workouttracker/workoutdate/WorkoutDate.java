package com.wt.workouttracker.workoutdate;

import com.wt.workouttracker.common.BaseModel;
import com.wt.workouttracker.workout.Workout;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	@NotNull
	private boolean completed = false;

	@Column(name = "started_at")
	private LocalDateTime startedAt;

	@Column(name = "ended_at")
	private LocalDateTime endedAt;

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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDateTime endedAt) {
		this.endedAt = endedAt;
	}
}
