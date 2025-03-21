package com.springboot.backend.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Inquiry {
    @Id
    @GeneratedValue
    public long id;

    public String name;
    public String email;
    public String message;
    public String petName;
    public String shelterName;
}
