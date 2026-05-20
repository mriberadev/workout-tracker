package com.wt.workouttracker.workoutdate.dto;

import com.wt.workouttracker.workoutdate.dto.validation.CreateWorkoutDateValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class WorkoutDateRequestDTO {

	@NotNull(groups = CreateWorkoutDateValidationGroup.class)
	private UUID workoutId;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate scheduledDate;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Schema(example = "10:43:12")
	private LocalTime scheduledTime;

	@NotNull
	private boolean completed = false;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime startedAt;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime endedAt;

	public UUID getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(UUID workoutId) {
		this.workoutId = workoutId;
	}

	public LocalDate getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public LocalTime getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(LocalTime scheduledTime) {
		this.scheduledTime = scheduledTime;
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
