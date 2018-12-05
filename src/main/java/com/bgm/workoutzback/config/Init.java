package com.bgm.workoutzback.config;

import com.bgm.workoutzback.model.Exercise;
import com.bgm.workoutzback.model.Program;
import com.bgm.workoutzback.model.ProgramWeek;
import com.bgm.workoutzback.repository.ExerciseRepository;
import com.bgm.workoutzback.repository.ProgramRepository;
import com.bgm.workoutzback.repository.ProgramWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Init {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private ProgramWeekRepository programWeekRepository;

    @Bean
    @Order(1)
    public CommandLineRunner initDb() {
        return args -> {
            this.initExercises();
            this.initPrograms();
            this.initProgramWeeks();
        };
    }

    private void initExercises() {
        exerciseRepository.save(new Exercise("Push Up", "http://"));
        exerciseRepository.save(new Exercise("Pull Up", "http://"));
        exerciseRepository.save(new Exercise("Dip", "http://"));
    }

    private void initPrograms() {
        programRepository.save(new Program("Beginner Program"));
        programRepository.save(new Program("Beginner Intermediate Program"));
        programRepository.save(new Program("Intermediate Program"));
    }

    private void initProgramWeeks() {
        Program program = programRepository.findById(1).orElse(null);
        programWeekRepository.save(new ProgramWeek(1, program));
        programWeekRepository.save(new ProgramWeek(2, program));
        programWeekRepository.save(new ProgramWeek(3, program));
        programWeekRepository.save(new ProgramWeek(4, program));
    }

}
