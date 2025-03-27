package com.springboot.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.springboot.backend.dto.*;
import com.springboot.backend.model.Pet;
import com.springboot.backend.service.PetService;

@RestController
@RequestMapping("/api/pet")
@CrossOrigin(origins = "http://localhost:3000")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/get/{id}")
    public Pet getPet(@PathVariable long id) {
        return petService.getPet(id);
    }

    @PostMapping("/add")
    public Pet addPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @PutMapping("/update/{id}")
    public Pet updatePet(@PathVariable long id, @RequestBody Pet pet) {
        pet.setId(id);
        return petService.updatePet(pet);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePet(@PathVariable long id) {
        return petService.deletePet(id);
    }

    @GetMapping("/shelterCountPerType")
    public List<ShelterPerCountDTO> getShelterPerCount() {
        return petService.getShelterPerCount();
    }

    @GetMapping("/countPerShelterAndType")
    public List<ShelterPerTypeDTO> getShelterPerType() {
        return petService.getShelterPerType();
    }

    @GetMapping("/allWithIds")
    public List<PetDTO> getAllPetsWithIds() {
        return petService.getAllPetsWithIds();
    }
}
