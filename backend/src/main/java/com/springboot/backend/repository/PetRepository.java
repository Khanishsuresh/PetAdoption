package com.springboot.backend.repository;

import com.springboot.backend.model.Pet;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetRepository extends JpaRepository <Pet , Long>{
    
}