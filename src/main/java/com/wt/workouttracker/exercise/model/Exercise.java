package com.wt.workouttracker.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
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

	// creation_date gets set only on first insert
	@PrePersist
	private void onCreate() {
		this.setCreation_date(LocalDateTime.now());
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
}
