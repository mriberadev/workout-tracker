package com.wt.workouttracker.workoutdate;

import com.wt.workouttracker.workout.WorkoutService;
import com.wt.workouttracker.workoutdate.dto.WorkoutDateRequestDTO;
import com.wt.workouttracker.workoutdate.dto.WorkoutDateResponseDTO;
import com.wt.workouttracker.workoutdate.exception.WorkoutDateNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutDateService {

	private WorkoutDateRepository workoutDateRepository;
	private WorkoutService workoutService;

	public WorkoutDateService(WorkoutDateRepository workoutDateRepository, WorkoutService workoutService) {
		this.workoutDateRepository = workoutDateRepository;
		this.workoutService = workoutService;
	}

	public List<WorkoutDateResponseDTO> getWorkoutDates() {

		List<WorkoutDate> workoutDates = workoutDateRepository.findAll();

		List<WorkoutDateResponseDTO> workoutDateResponseDTOS = workoutDates.stream().map(
				workoutDate -> WorkoutDateMapper.toDTO(workoutDate)).toList();

		return workoutDateResponseDTOS;
	}

	public WorkoutDateResponseDTO getWorkoutDateById(UUID id) {

		WorkoutDate workoutDate = workoutDateRepository.findById(id).orElseThrow(
				() -> new WorkoutDateNotFoundException("Workout date not found for ID: " + id));

		return WorkoutDateMapper.toDTO(workoutDate);
	}

	public WorkoutDateResponseDTO createWorkoutDate(WorkoutDateRequestDTO workoutDateRequestDTO) {

		WorkoutDate workoutDate = WorkoutDateMapper.toModel(workoutDateRequestDTO);
		workoutDate.setWorkout(workoutService.getWorkoutObjectById(workoutDateRequestDTO.getWorkoutId()));

		WorkoutDate newWorkoutDate = workoutDateRepository.save(workoutDate);

		return WorkoutDateMapper.toDTO(newWorkoutDate);
	}

	public WorkoutDateResponseDTO updateWorkoutDate(UUID id, WorkoutDateRequestDTO workoutDateRequestDTO) {

		WorkoutDate workoutDate = workoutDateRepository.findById(id).orElseThrow(
				() -> new WorkoutDateNotFoundException("Workout date not found for ID: " + id));

		workoutDate.setScheduledDate(workoutDateRequestDTO.getScheduledDate());
		workoutDate.setScheduledTime(workoutDateRequestDTO.getScheduledTime());

		WorkoutDate updatedWorkoutDate = workoutDateRepository.save(workoutDate);

		return WorkoutDateMapper.toDTO(updatedWorkoutDate);
	}

	public void deleteWorkoutDate(UUID id) {

		if (!workoutDateRepository.existsById(id)){
			throw new WorkoutDateNotFoundException("Workout date not found for ID: " + id);
		}
		workoutDateRepository.deleteById(id);
	}
}
