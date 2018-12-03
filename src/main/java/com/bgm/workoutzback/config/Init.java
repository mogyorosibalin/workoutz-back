package com.bgm.workoutzback.config;

import com.bgm.workoutzback.model.Exercise;
import com.bgm.workoutzback.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Init {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Bean
    @Order(1)
    public CommandLineRunner initDb() {
        return args -> {
            this.initExercises();
        };
    }

    private void initExercises() {
        exerciseRepository.save(new Exercise("Push Up", "http://"));
        exerciseRepository.save(new Exercise("Pull Up", "http://"));
        exerciseRepository.save(new Exercise("Dip", "http://"));
    }

}
