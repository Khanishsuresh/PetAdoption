package com.springboot.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    public long id;

    public String name;
    public String type;
    public String breed;
    public String age;
}