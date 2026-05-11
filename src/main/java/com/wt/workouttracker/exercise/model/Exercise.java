package com.wt.workouttracker.exercise.model;

import com.wt.workouttracker.common.model.BaseModel;
import com.wt.workouttracker.workoutexercise.model.WorkoutExercise;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Exercise extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotEmpty
	private String name;

	@URL
	private String image;

	@URL
	private String video;

	@OneToMany(mappedBy = "exercise", cascade = {CascadeType.REMOVE})
	private List<WorkoutExercise> workoutExerciseList = new ArrayList<>();

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

	public List<WorkoutExercise> getWorkoutExerciseList() {
		return workoutExerciseList;
	}

	public void setWorkoutExerciseList(List<WorkoutExercise> workoutExerciseList) {
		this.workoutExerciseList = workoutExerciseList;
	}
}
