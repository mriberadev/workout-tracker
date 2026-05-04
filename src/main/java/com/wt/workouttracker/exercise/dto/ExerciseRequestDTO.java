package com.wt.workouttracker.exercise.dto;

import com.wt.workouttracker.exercise.dto.validators.CreateExerciseValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class ExerciseRequestDTO {

	@NotBlank
	@Size(max = 200)
	private String name;

	@URL
	private String image;

	@URL
	private String video;

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
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}