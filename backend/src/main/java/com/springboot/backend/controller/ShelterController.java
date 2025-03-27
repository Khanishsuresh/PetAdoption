package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.backend.model.Shelter;
import com.springboot.backend.service.ShelterService;

@RestController
@RequestMapping("/api/shelters")
@CrossOrigin(origins = "http://localhost:3000")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping
    public ResponseEntity<List<Shelter>> getAllShelters() {
        return ResponseEntity.ok(shelterService.getAllShelters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelter> getShelter(@PathVariable long id) {
        Shelter shelter = shelterService.getShelter(id);
        return shelter != null ? ResponseEntity.ok(shelter) : ResponseEntity.status(404).body(null);
    }

    @PostMapping
    public ResponseEntity<Shelter> addShelter(@RequestBody Shelter shelter) {
        return ResponseEntity.ok(shelterService.addShelter(shelter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shelter> updateShelter(@PathVariable long id, @RequestBody Shelter shelter) {
        shelter.setId(id);
        try{
            return ResponseEntity.ok(shelterService.updateShelter(shelter));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShelter(@PathVariable long id) {
        return shelterService.deleteShelter(id);
    }
}
