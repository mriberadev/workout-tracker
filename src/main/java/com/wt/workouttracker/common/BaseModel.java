package com.wt.workouttracker.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public class BaseModel {

	@NotNull
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@NotNull
	@Column(name = "last_modification_date")
	private LocalDateTime lastModificationDate;

	// creationDate gets set only on first insert
	@PrePersist
	final void onCreate() {
		this.setCreationDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
		this.setLastModificationDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
	}

	// lastModificationDate gets set every update
	@PreUpdate
	final void onUpdate() {
		this.setLastModificationDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
}
