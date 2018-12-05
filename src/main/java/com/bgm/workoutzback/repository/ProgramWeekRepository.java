package com.bgm.workoutzback.repository;

import com.bgm.workoutzback.model.ProgramWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramWeekRepository extends JpaRepository<ProgramWeek, Long> {
}
