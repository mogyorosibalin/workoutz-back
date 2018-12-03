package com.bgm.workoutzback.api;

import com.bgm.workoutzback.model.Exercise;
import com.bgm.workoutzback.repository.ExerciseRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
public class ExerciseRestController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/exercises/{id}")
    public Exercise getExercise(@PathVariable("id") long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    @PostMapping("/exercises/save-new")
    public Exercise saveNewExercise(@RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        Exercise exercise = new Exercise((String) request.get("name"), (String) request.get("videoLink"));
        return exerciseRepository.save(exercise);
    }

    @PutMapping("/exercises/{id}/edit")
    public Exercise editExercise(@RequestBody String body, @PathVariable("id") long id) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        Exercise exercise = exerciseRepository.findById(id).orElse(null);
        exercise.setName((String) request.get("name"));
        exercise.setVideoLink((String) request.get("videoLink"));
        return exerciseRepository.save(exercise);
    }

    @DeleteMapping("/exercises/{id}/delete")
    public String deleteExercise(@PathVariable("id") long id) {
        exerciseRepository.delete(exerciseRepository.findById(id).orElse(null));
        return null;
    }

}
