package com.bgm.workoutzback.api;

import com.bgm.workoutzback.model.Program;
import com.bgm.workoutzback.model.ProgramWeek;
import com.bgm.workoutzback.repository.ProgramRepository;
import com.bgm.workoutzback.repository.ProgramWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
public class ProgramRestController {

    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private ProgramWeekRepository programWeekRepository;

    @GetMapping("/programs")
    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

    @GetMapping("/programs/{id}")
    public Program getProgram(@PathVariable("id") long id) {
        return programRepository.findById(id).orElse(null);
    }

    @GetMapping("/programs/{id}/weeks")
    public List<ProgramWeek> getProgramWeeks(@PathVariable("id") long programId) {
        Program program = programRepository.findById(programId).orElse(null);
        return programWeekRepository.findByProgram(program);
    }

}
