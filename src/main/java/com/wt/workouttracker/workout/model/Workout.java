package com.wt.workouttracker.workout.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotEmpty
	private String name;

	@NotNull
	private LocalDateTime creation_date;

	@NotNull
	private LocalDateTime last_modification_date;

	// creation_date gets set only on first insert
	@PrePersist
	final void onCreate() {
		this.setCreation_date(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		this.setLast_modification_date(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
	}

	// last_modification_date gets set every update
	@PreUpdate
	final void onUpdate() {
		this.setLast_modification_date(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
	}

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

	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}

	public LocalDateTime getLast_modification_date() {
		return last_modification_date;
	}

	public void setLast_modification_date(LocalDateTime last_modification_date) {
		this.last_modification_date = last_modification_date;
	}
}
