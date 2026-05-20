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
		workoutDateResponseDTO.setCompleted(workoutDate.isCompleted());
		workoutDateResponseDTO.setStartedAt(workoutDate.getStartedAt() != null ? workoutDate.getStartedAt().toString() : null);
		workoutDateResponseDTO.setEndedAt(workoutDate.getEndedAt() != null ? workoutDate.getEndedAt().toString() : null);
		workoutDateResponseDTO.setLastModificationDate(workoutDate.getLastModificationDate().toString());

		return workoutDateResponseDTO;
	}

	public static WorkoutDate toModel(WorkoutDateRequestDTO workoutDateRequestDTO) {
		WorkoutDate workoutDate = new WorkoutDate();

		workoutDate.setScheduledDate(workoutDateRequestDTO.getScheduledDate());
		workoutDate.setScheduledTime(workoutDateRequestDTO.getScheduledTime());
		workoutDate.setCompleted(workoutDateRequestDTO.isCompleted());
		workoutDate.setStartedAt(workoutDateRequestDTO.getStartedAt());
		workoutDate.setEndedAt(workoutDateRequestDTO.getEndedAt());

		return workoutDate;
	}
}
