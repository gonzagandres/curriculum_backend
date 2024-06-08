package com.curriculum.backend.controller;

import com.curriculum.backend.models.Skill;
import com.curriculum.backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/skills")
public class SkillController {
    @Autowired
    private SkillRepository repository;

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    @PostMapping
    public Skill saveSkill(@RequestBody Skill skill) {
        return repository.save(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        if (repository.existsById(id)) {
            skill.setId(id);
            return repository.save(skill);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

