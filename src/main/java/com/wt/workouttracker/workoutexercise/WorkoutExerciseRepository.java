package com.wt.workouttracker.workoutexercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, WorkoutExerciseId> {
}
