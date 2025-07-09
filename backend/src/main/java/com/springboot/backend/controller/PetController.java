package com.springboot.backend.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.dto.*;
import com.springboot.backend.model.Pet;
import com.springboot.backend.service.PetService;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable long id) {
        Pet pet = petService.getPet(id);
        return pet != null ? ResponseEntity.ok(pet) : ResponseEntity.status(404).body(null);
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.addPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable long id, @RequestBody Pet pet) {
        pet.setId(id);
        try{
            return ResponseEntity.ok(petService.updatePet(pet));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable long id) {
        return petService.deletePet(id);
    }

    @GetMapping("/shelterCountPerType")
    public ResponseEntity<List<ShelterPerCountDTO>> getShelterPerCount() {
        return ResponseEntity.ok(petService.getShelterPerCount());
    }

    @GetMapping("/countPerShelterAndType")
    public ResponseEntity<List<ShelterPerTypeDTO>> getShelterPerType() {
        return ResponseEntity.ok(petService.getShelterPerType());
    }

    @GetMapping("/allWithIds")
    public ResponseEntity<List<PetDTO>> getAllPetsWithIds() {
        return ResponseEntity.ok(petService.getAllPetsWithIds());
    }
}
