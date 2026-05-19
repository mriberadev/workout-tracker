package com.wt.workouttracker.workoutdate.repository;

import com.wt.workouttracker.workoutdate.model.WorkoutDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutDateRepository extends JpaRepository<WorkoutDate, UUID> {
}
