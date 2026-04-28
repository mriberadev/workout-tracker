package com.wt.workouttracker.exercise.repository;

import com.wt.workouttracker.exercise.model.Exercise;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

}
