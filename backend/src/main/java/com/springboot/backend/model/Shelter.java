package com.springboot.backend.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Shelter {
    @Id
    @GeneratedValue
    public long id;

    public String name;
    public String address;
    public String phone;
    public String email;
}
