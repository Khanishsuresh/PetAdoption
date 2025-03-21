package com.springboot.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
