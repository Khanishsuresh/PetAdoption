package com.springboot.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.springboot.backend.model.Shelter;
import com.springboot.backend.service.ShelterService;

@RestController
@RequestMapping("/api/shelter")
public class ShelterController {

    private ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @GetMapping("/all")
    public List<Shelter> getAllShelters() {
        return shelterService.getAllShelters();
    }

    @GetMapping("/get/{id}")
    public Shelter getShelter(@PathVariable long id) {
        return shelterService.getShelter(id);
    }

    @PostMapping("/add")
    public Shelter addShelter(@RequestBody Shelter shelter) {
        return shelterService.addShelter(shelter);
    }

    @PutMapping("/update/{id}")
    public Shelter updateShelter(@PathVariable long id, @RequestBody Shelter shelter) {
        shelter.setId(id);
        return shelterService.updateShelter(shelter);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShelter(@PathVariable long id) {
        return shelterService.deleteShelter(id);
    }
}
