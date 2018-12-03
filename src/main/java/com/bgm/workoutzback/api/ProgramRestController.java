package com.bgm.workoutzback.api;

import com.bgm.workoutzback.model.Program;
import com.bgm.workoutzback.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgramRestController {

    @Autowired
    private ProgramRepository programRepository;

    @GetMapping("/programs")
    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/programs/{id}")
    public Program getProgram(@PathVariable("id") long id) {
        return programRepository.findById(id).orElse(null);
    }

}
