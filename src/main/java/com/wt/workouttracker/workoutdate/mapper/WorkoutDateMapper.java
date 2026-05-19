package com.wt.workouttracker.workoutdate.mapper;

import com.wt.workouttracker.workoutdate.dto.WorkoutDateRequestDTO;
import com.wt.workouttracker.workoutdate.dto.WorkoutDateResponseDTO;
import com.wt.workouttracker.workoutdate.model.WorkoutDate;

public class WorkoutDateMapper {

	public static WorkoutDateResponseDTO toDTO(WorkoutDate workoutDate) {
		WorkoutDateResponseDTO workoutDateResponseDTO = new WorkoutDateResponseDTO();

		workoutDateResponseDTO.setId(workoutDate.getId().toString());
		workoutDateResponseDTO.setWorkoutId(workoutDate.getWorkout().getId().toString());
		workoutDateResponseDTO.setDate(workoutDate.getDate().toString());
		workoutDateResponseDTO.setTime(workoutDate.getTime().toString());
		workoutDateResponseDTO.setLastModificationDate(workoutDate.getLastModificationDate().toString());

		return workoutDateResponseDTO;
	}

	public static WorkoutDate toModel(WorkoutDateRequestDTO workoutDateRequestDTO) {
		WorkoutDate workoutDate = new WorkoutDate();

		workoutDate.setDate(workoutDateRequestDTO.getDate());
		workoutDate.setTime(workoutDateRequestDTO.getTime());

		return workoutDate;
	}
}
