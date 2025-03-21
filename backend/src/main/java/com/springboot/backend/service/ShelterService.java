package com.springboot.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.model.Shelter;
import com.springboot.backend.repository.ShelterRepository;

@Service
public class ShelterService {
    
    @Autowired
    private ShelterRepository shelterRepository;

    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }
}
