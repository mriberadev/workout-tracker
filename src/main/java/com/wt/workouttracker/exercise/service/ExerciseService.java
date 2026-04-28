package com.wt.workouttracker.exercise.service;

import com.wt.workouttracker.exercise.dto.ExerciseResponseDTO;
import com.wt.workouttracker.exercise.mapper.ExerciseMapper;
import com.wt.workouttracker.exercise.model.Exercise;
import com.wt.workouttracker.exercise.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
