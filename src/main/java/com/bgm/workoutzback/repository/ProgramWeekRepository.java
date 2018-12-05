package com.bgm.workoutzback.repository;

import com.bgm.workoutzback.model.Program;
import com.bgm.workoutzback.model.ProgramWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramWeekRepository extends JpaRepository<ProgramWeek, Long> {

    List<ProgramWeek> findByProgram(Program program);

}
