package com.springboot.backend.repository;

import java.util.*;
import com.springboot.backend.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.password = :password")
    Optional<User> findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
