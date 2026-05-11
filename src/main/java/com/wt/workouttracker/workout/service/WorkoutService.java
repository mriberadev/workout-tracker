package com.wt.workouttracker.workout.service;

import com.wt.workouttracker.workout.dto.WorkoutRequestDTO;
import com.wt.workouttracker.workout.dto.WorkoutResponseDTO;
import com.wt.workouttracker.workout.exception.WorkoutNotFoundException;
import com.wt.workouttracker.workout.mapper.WorkoutMapper;
import com.wt.workouttracker.workout.model.Workout;
import com.wt.workouttracker.workout.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutService {

	private WorkoutRepository workoutRepository;

	public WorkoutService(WorkoutRepository workoutRepository) {
		this.workoutRepository = workoutRepository;
	}

	public List<WorkoutResponseDTO> getWorkouts() {
		List<Workout> workouts = workoutRepository.findAll();


		List<WorkoutResponseDTO> workoutResponseDTOS = workouts.stream().map(
				workout -> WorkoutMapper.toDTO(workout)).toList();

		return workoutResponseDTOS;
	}

	public WorkoutResponseDTO getWorkoutById(UUID id) {
		Workout workout = workoutRepository.findById(id).orElseThrow(
				() -> new WorkoutNotFoundException("Workout not found for ID: " + id));

		return WorkoutMapper.toDTO(workout);
	}

	public Workout getWorkoutObjectById(UUID id) {
		return workoutRepository.findById(id).orElseThrow(
				() -> new WorkoutNotFoundException("Workout not found for ID: " + id));
	}

	public WorkoutResponseDTO createWorkout(WorkoutRequestDTO workoutRequestDTO) {
		Workout newWorkout = workoutRepository.save(
				WorkoutMapper.toModel(workoutRequestDTO));

		return WorkoutMapper.toDTO(newWorkout);
	}

	public WorkoutResponseDTO updateWorkout(UUID id, WorkoutRequestDTO workoutRequestDTO) {

		Workout workout = workoutRepository.findById(id).orElseThrow(
				() -> new WorkoutNotFoundException("Workout not found for ID: " + id));

		workout.setName(workoutRequestDTO.getName());

		Workout updatedWorkout = workoutRepository.save(workout);
		return WorkoutMapper.toDTO(updatedWorkout);
	}

	public void deleteWorkout(UUID id) {

		if (!workoutRepository.existsById(id)) {
			throw new WorkoutNotFoundException("Workout not found for ID: " + id);
		}
		workoutRepository.deleteById(id);
	}
}
