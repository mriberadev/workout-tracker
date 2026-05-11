package com.wt.workouttracker.workoutexercise.repository;

import com.wt.workouttracker.workoutexercise.model.WorkoutExercise;
import com.wt.workouttracker.workoutexercise.model.WorkoutExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, WorkoutExerciseId> {
}
