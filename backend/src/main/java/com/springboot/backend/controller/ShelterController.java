package com.springboot.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Shelter;
import com.springboot.backend.service.ShelterService;

@RestController
@RequestMapping("/api/shelter")
public class ShelterController {

    private ShelterService shelterService;
    public ShelterController (ShelterService shelterService){
        this.shelterService = shelterService;
    }
    
    @GetMapping("/all")
    public List<Shelter> getAllShelters() {
        return shelterService.getAllShelters();
    }
    
}
