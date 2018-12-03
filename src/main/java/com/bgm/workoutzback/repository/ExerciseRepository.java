package com.bgm.workoutzback.repository;

import com.bgm.workoutzback.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findById(Long id);

}
