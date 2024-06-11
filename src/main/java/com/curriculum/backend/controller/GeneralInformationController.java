package com.curriculum.backend.controller;

import com.curriculum.backend.models.GeneralInformation;
import com.curriculum.backend.repository.GeneralInformationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://master--curriculum-vitae-udea.netlify.app/")
@RestController
@RequestMapping("/api/general-information")
public class GeneralInformationController {

    @Autowired
    private GeneralInformationRepository repository;

    @GetMapping("/{id}")
    public GeneralInformation getGeneralInformation(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<GeneralInformation> getAllGeneralInformation() {
        return repository.findAll();
    }

    @PostMapping
    public GeneralInformation saveGeneralInformation(@RequestBody GeneralInformation info) {
        return repository.save(info);
    }

    @PutMapping("/{id}")
    public GeneralInformation updateGeneralInformation(@PathVariable Long id, @RequestBody GeneralInformation info) {
        if (repository.existsById(id)) {
            info.setId(id);
            return repository.save(info);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGeneralInformation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

