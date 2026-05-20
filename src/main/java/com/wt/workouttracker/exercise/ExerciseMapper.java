package com.wt.workouttracker.exercise;

import com.wt.workouttracker.exercise.dto.ExerciseRequestDTO;
import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;

public class ExerciseMapper {
	public static ExerciseResponseDTO toDTO(Exercise exercise) {
		ExerciseResponseDTO exerciseResponseDTO = new ExerciseResponseDTO();
		exerciseResponseDTO.setId(exercise.getId().toString());
		exerciseResponseDTO.setName(exercise.getName());
		exerciseResponseDTO.setImage(exercise.getImage());
		exerciseResponseDTO.setVideo(exercise.getVideo());
		exerciseResponseDTO.setNotes(exercise.getNotes());
		exerciseResponseDTO.setLastModificationDate(exercise.getLastModificationDate().toString());

		return exerciseResponseDTO;
	}

	public static Exercise toModel(ExerciseRequestDTO exerciseRequestDTO) {
		Exercise exercise = new Exercise();
		exercise.setName(exerciseRequestDTO.getName());
		exercise.setImage(exerciseRequestDTO.getImage());
		exercise.setVideo(exerciseRequestDTO.getVideo());
		exercise.setNotes(exerciseRequestDTO.getNotes());

		return exercise;
	}
}
