package com.wt.workouttracker.workoutexercise;

import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseRequestDTO;
import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseResponseDTO;

public class WorkoutExerciseMapper {

	public static WorkoutExerciseResponseDTO toDTO(WorkoutExercise workoutExercise) {

		WorkoutExerciseResponseDTO workoutExerciseResponseDTO = new WorkoutExerciseResponseDTO();

		workoutExerciseResponseDTO.setWorkoutId(
				workoutExercise.getId().getWorkoutId().toString());
		workoutExerciseResponseDTO.setExerciseId(
				workoutExercise.getId().getExerciseId().toString());
		workoutExerciseResponseDTO.setSets(
				workoutExercise.getSets());
		workoutExerciseResponseDTO.setReps(
				workoutExercise.getReps());
		workoutExerciseResponseDTO.setRestSeconds(
				workoutExercise.getRestSeconds());
		workoutExerciseResponseDTO.setLastModificationDate(
				workoutExercise.getLastModificationDate().toString());

		return workoutExerciseResponseDTO;
	}

	public static WorkoutExercise toModel(WorkoutExerciseRequestDTO workoutExerciseRequestDTO) {

		WorkoutExercise workoutExercise = new WorkoutExercise();
		WorkoutExerciseId workoutExerciseId = new WorkoutExerciseId();

		workoutExerciseId.setWorkoutId(workoutExerciseRequestDTO.getWorkoutId());
		workoutExerciseId.setExerciseId(workoutExerciseRequestDTO.getExerciseId());

		workoutExercise.setId(workoutExerciseId);
		workoutExercise.setSets(workoutExerciseRequestDTO.getSets());
		workoutExercise.setReps(workoutExerciseRequestDTO.getReps());
		workoutExercise.setRestSeconds(workoutExerciseRequestDTO.getRestSeconds());

		return workoutExercise;
	}


}
