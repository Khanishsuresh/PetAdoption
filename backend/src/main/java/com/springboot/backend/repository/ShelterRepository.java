package com.springboot.backend.repository;

import com.springboot.backend.model.Shelter;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> {

}
