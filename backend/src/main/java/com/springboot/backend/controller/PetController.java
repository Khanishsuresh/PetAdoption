package com.springboot.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.springboot.backend.model.Pet;
import com.springboot.backend.service.PetService;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private PetService petService;
    public PetController (PetService petService){
        this.petService = petService;
    }
    
    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/get/{id}")
    public Pet getPet(@PathVariable long id) {
        return petService.addPet(id);
    }

}
