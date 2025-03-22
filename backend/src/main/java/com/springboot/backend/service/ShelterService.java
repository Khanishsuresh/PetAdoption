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

    public Shelter getShelter(long id) {
        return shelterRepository.findById(id).orElse(null);
    }

    public Shelter addShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public Shelter updateShelter(Shelter shelter) {
        return shelterRepository.findById(shelter.getId())
                .map(existingShelter -> {
                    existingShelter.setName(shelter.getName());
                    existingShelter.setLocation(shelter.getLocation());
                    existingShelter.setPets(shelter.getPets());
                    return shelterRepository.save(existingShelter);
                })
                .orElseThrow(() -> new RuntimeException("Shelter not found with ID: " + shelter.getId()));
    }

    public String deleteShelter(long id) {
        shelterRepository.deleteById(id);
        return "Shelter removed !! " + id;
    }
}
