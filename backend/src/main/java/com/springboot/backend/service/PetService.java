package com.springboot.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.dto.ShelterPerCountDTO;
import com.springboot.backend.dto.ShelterPerTypeDTO;
import com.springboot.backend.model.Pet;
import com.springboot.backend.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPet(long id) {
        return petRepository.findById(id).orElse(null);
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet) {
        return petRepository.findById(pet.getId())
                .map(existingPet -> {
                    existingPet.setName(pet.getName());
                    existingPet.setType(pet.getType());
                    existingPet.setBreed(pet.getBreed());
                    existingPet.setAge(pet.getAge());
                    existingPet.setDescription(pet.getDescription());
                    return petRepository.save(existingPet);
                })
                .orElseThrow(() -> new RuntimeException("Pet not found with ID: " + pet.getId()));
    }

    public String deletePet(long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
            return "Pet removed: " + id;
        } else {
            return "Pet not found with ID: " + id;
        }
    }

    public List<ShelterPerCountDTO> getShelterPerCount() {
        return petRepository.getShelterCountPerType();
    }

    public List<ShelterPerTypeDTO> getShelterPerType() {
        return petRepository.getShelterPerTypeCount();
    }
}
