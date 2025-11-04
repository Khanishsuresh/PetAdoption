package com.springboot.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
        if(shelter == null){
            throw new IllegalArgumentException("Shelter cannot be null");
        }
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

    public ResponseEntity<String> deleteShelter(long id) {
        if(shelterRepository.existsById(id)){
            shelterRepository.deleteById(id);
            return ResponseEntity.ok("Shelter removed !! " + id);
        } else {
            return ResponseEntity.status(404).body("Shelter not found with ID: " + id);
        }
    }
}
