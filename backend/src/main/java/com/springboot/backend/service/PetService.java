package com.springboot.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.model.Pet;
import com.springboot.backend.repository.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;
    
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
