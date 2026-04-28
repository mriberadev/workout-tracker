package com.wt.workouttracker.exercise.mapper;

import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.model.Exercise;

public class ExerciseMapper {
	public static ExerciseResponseDTO toDTO(Exercise exercise) {
		ExerciseResponseDTO exerciseResponseDTO = new ExerciseResponseDTO();
		exerciseResponseDTO.setId(exercise.getId().toString());
		exerciseResponseDTO.setName(exercise.getName());
		exerciseResponseDTO.setImage(exercise.getImage());
		exerciseResponseDTO.setVideo(exercise.getVideo());

		return exerciseResponseDTO;
	}
}
