package com.wt.workouttracker.exercise.service;

import com.wt.workouttracker.exercise.dto.ExerciseRequestDTO;
import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.exception.ExerciseNotFoundException;
import com.wt.workouttracker.exercise.mapper.ExerciseMapper;
import com.wt.workouttracker.exercise.model.Exercise;
import com.wt.workouttracker.exercise.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExerciseService {

	private ExerciseRepository exerciseRepository;

	public ExerciseService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}

	public List<ExerciseResponseDTO> getExercises() {
		List<Exercise> exercises = exerciseRepository.findAll();


		List<ExerciseResponseDTO> exerciseResponseDTOS = exercises.stream().map(
				exercise -> ExerciseMapper.toDTO(exercise)).toList();

		return exerciseResponseDTOS;
	}

	public ExerciseResponseDTO createExercise(ExerciseRequestDTO exerciseRequestDTO) {
		Exercise newExercise = exerciseRepository.save(
				ExerciseMapper.toModel(exerciseRequestDTO));

		return ExerciseMapper.toDTO(newExercise);
	}

	public ExerciseResponseDTO updateExercise(UUID id, ExerciseRequestDTO exerciseRequestDTO) {

		Exercise exercise = exerciseRepository.findById(id).orElseThrow(
				() -> new ExerciseNotFoundException("Exercise not found for ID: " + id));

		exercise.setName(exerciseRequestDTO.getName());
		exercise.setImage(exerciseRequestDTO.getImage());
		exercise.setVideo(exerciseRequestDTO.getVideo());

		Exercise updatedExercise = exerciseRepository.save(exercise);
		return ExerciseMapper.toDTO(updatedExercise);
	}
}
