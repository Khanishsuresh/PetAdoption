package com.springboot.backend.repository;

import java.util.*;

import com.springboot.backend.dto.*;
import com.springboot.backend.model.Pet;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT shelter_id AS shelterId, COUNT(*) AS petCount FROM pet GROUP BY shelter_id", nativeQuery = true)
    List<ShelterPerCountDTO> getShelterCountPerType();

    @Query(value = "select shelter_id , type , count(*) as type_count from pet group by shelter_id , type;", nativeQuery = true)
    List<ShelterPerTypeDTO> getShelterPerTypeCount();
}
