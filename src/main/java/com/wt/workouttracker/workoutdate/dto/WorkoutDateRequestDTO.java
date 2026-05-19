package com.wt.workouttracker.workoutdate.dto;

import com.wt.workouttracker.workoutdate.dto.validation.CreateWorkoutDateValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class WorkoutDateRequestDTO {

	@NotNull(groups = CreateWorkoutDateValidationGroup.class)
	private UUID workoutId;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Schema(example = "10:43:12")
	private LocalTime time;

	public UUID getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(UUID workoutId) {
		this.workoutId = workoutId;
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
