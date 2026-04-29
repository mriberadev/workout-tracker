package com.wt.workouttracker.exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
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
	private LocalDate creation_date;


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

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
}
