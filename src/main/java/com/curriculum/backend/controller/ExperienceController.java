package com.curriculum.backend.controller;

import com.curriculum.backend.models.Experience;
import com.curriculum.backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    
    @Autowired
    private ExperienceRepository repository;

    @GetMapping("/{id}")
    public Experience getExperience(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return repository.findAll();
    }

    @PostMapping
    public Experience saveExperience(@RequestBody Experience experience) {
        return repository.save(experience);
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        if (repository.existsById(id)) {
            experience.setId(id);
            return repository.save(experience);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

