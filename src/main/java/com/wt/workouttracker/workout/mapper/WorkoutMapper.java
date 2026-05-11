package com.wt.workouttracker.workout.mapper;

import com.wt.workouttracker.workout.dto.WorkoutRequestDTO;
import com.wt.workouttracker.workout.dto.WorkoutResponseDTO;
import com.wt.workouttracker.workout.model.Workout;

public class WorkoutMapper {

	public static WorkoutResponseDTO toDTO(Workout workout) {

		WorkoutResponseDTO workoutResponseDTO = new WorkoutResponseDTO();

		workoutResponseDTO.setId(workout.getId().toString());
		workoutResponseDTO.setName(workout.getName());
		workoutResponseDTO.setLastModificationDate(workout.getLastModificationDate().toString());

		return workoutResponseDTO;
	}

	public static Workout toModel(WorkoutRequestDTO workoutRequestDTO) {

		Workout workout = new Workout();

		workout.setName(workoutRequestDTO.getName());

		return workout;
	}
}
