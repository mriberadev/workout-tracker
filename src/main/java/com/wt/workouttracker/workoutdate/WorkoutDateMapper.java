package com.wt.workouttracker.workoutdate;

import com.wt.workouttracker.workoutdate.dto.WorkoutDateRequestDTO;
import com.wt.workouttracker.workoutdate.dto.WorkoutDateResponseDTO;

public class WorkoutDateMapper {

	public static WorkoutDateResponseDTO toDTO(WorkoutDate workoutDate) {
		WorkoutDateResponseDTO workoutDateResponseDTO = new WorkoutDateResponseDTO();

		workoutDateResponseDTO.setId(workoutDate.getId().toString());
		workoutDateResponseDTO.setWorkoutId(workoutDate.getWorkout().getId().toString());
		workoutDateResponseDTO.setScheduledDate(workoutDate.getScheduledDate().toString());
		workoutDateResponseDTO.setScheduledTime(workoutDate.getScheduledTime().toString());
		workoutDateResponseDTO.setLastModificationDate(workoutDate.getLastModificationDate().toString());

		return workoutDateResponseDTO;
	}

	public static WorkoutDate toModel(WorkoutDateRequestDTO workoutDateRequestDTO) {
		WorkoutDate workoutDate = new WorkoutDate();

		workoutDate.setScheduledDate(workoutDateRequestDTO.getScheduledDate());
		workoutDate.setScheduledTime(workoutDateRequestDTO.getScheduledTime());

		return workoutDate;
	}
}
