package com.wt.workouttracker.workoutexercise.service;

import com.wt.workouttracker.exercise.service.ExerciseService;
import com.wt.workouttracker.workout.service.WorkoutService;
import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseRequestDTO;
import com.wt.workouttracker.workoutexercise.dto.WorkoutExerciseResponseDTO;
import com.wt.workouttracker.workoutexercise.exception.WorkoutExerciseNotFoundException;
import com.wt.workouttracker.workoutexercise.mapper.WorkoutExerciseMapper;
import com.wt.workouttracker.workoutexercise.model.WorkoutExercise;
import com.wt.workouttracker.workoutexercise.model.WorkoutExerciseId;
import com.wt.workouttracker.workoutexercise.repository.WorkoutExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutExerciseService {

	private WorkoutExerciseRepository workoutExerciseRepository;
	private WorkoutService workoutService;
	private ExerciseService exerciseService;

	public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository, WorkoutService workoutService, ExerciseService exerciseService) {
		this.workoutExerciseRepository = workoutExerciseRepository;
		this.workoutService = workoutService;
		this.exerciseService = exerciseService;
	}

	public List<WorkoutExerciseResponseDTO> getWorkoutExercises() {
		List<WorkoutExercise> workoutExercises = workoutExerciseRepository.findAll();


		List<WorkoutExerciseResponseDTO> workoutExerciseResponseDTOS = workoutExercises.stream().map(
				workoutExercise -> WorkoutExerciseMapper.toDTO(workoutExercise)).toList();

		return workoutExerciseResponseDTOS;
	}

	public WorkoutExerciseResponseDTO getWorkoutExerciseByWorkoutIdAndExerciseId(UUID workoutId, UUID exerciseId) {
		WorkoutExercise workoutExercise = workoutExerciseRepository.findById(
				new WorkoutExerciseId(workoutId, exerciseId)).orElseThrow(
				() -> new WorkoutExerciseNotFoundException("WorkoutExercise not found for workout ID " +
						workoutId + " and exercise ID " + exerciseId));

		return WorkoutExerciseMapper.toDTO(workoutExercise);
	}

	public WorkoutExerciseResponseDTO createWorkoutExercise(WorkoutExerciseRequestDTO workoutExerciseRequestDTO) {

		WorkoutExercise workoutExercise = WorkoutExerciseMapper.toModel(workoutExerciseRequestDTO);
		workoutExercise.setWorkout(workoutService.getWorkoutObjectById(workoutExerciseRequestDTO.getWorkoutId()));
		workoutExercise.setExercise(exerciseService.getExerciseObjectById(workoutExerciseRequestDTO.getExerciseId()));

		WorkoutExercise newWorkoutExercise = workoutExerciseRepository.save(workoutExercise);

		return WorkoutExerciseMapper.toDTO(newWorkoutExercise);
	}

	public WorkoutExerciseResponseDTO updateWorkoutExercise(
			UUID workoutId, UUID exerciseId, WorkoutExerciseRequestDTO workoutExerciseRequestDTO) {

		WorkoutExercise workoutExercise = workoutExerciseRepository.findById(
				new WorkoutExerciseId(workoutId, exerciseId)).orElseThrow(
				() -> new WorkoutExerciseNotFoundException("WorkoutExercise not found for workout ID " +
						workoutId + " and exercise ID " + exerciseId));

		workoutExercise.setSets(workoutExerciseRequestDTO.getSets());
		workoutExercise.setReps(workoutExerciseRequestDTO.getReps());
		workoutExercise.setRestSeconds(workoutExerciseRequestDTO.getRestSeconds());

		WorkoutExercise updatedWorkoutExercise = workoutExerciseRepository.save(workoutExercise);
		return WorkoutExerciseMapper.toDTO(updatedWorkoutExercise);
	}

	public void deleteWorkoutExercise(UUID workoutId, UUID exerciseId) {

		WorkoutExerciseId workoutExerciseId = new WorkoutExerciseId(workoutId, exerciseId);

		if (!workoutExerciseRepository.existsById(workoutExerciseId)) {
			throw new WorkoutExerciseNotFoundException("WorkoutExercise not found for workout ID " +
					workoutId + " and exercise ID " + exerciseId);
		}
		workoutExerciseRepository.deleteById(workoutExerciseId);
	}
}
