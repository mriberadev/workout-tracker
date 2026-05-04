package com.wt.workouttracker.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull
	private String name;

	@URL
	private String image;

	@URL
	private String video;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		if (image != null && image.isEmpty()) image = null;
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		if (video != null && video.isEmpty()) video = null;
		this.video = video;
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
