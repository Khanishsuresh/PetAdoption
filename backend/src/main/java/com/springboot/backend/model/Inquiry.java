package com.springboot.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inquiry")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String message;

    @Column(nullable = false)
    private LocalDateTime inqueryDateTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "pet_id" , nullable = false)
    private Pet pet;

    public Inquiry() {
    }

    public Inquiry(String name, String email, String message, Pet pet) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.pet = pet;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getInqueryDateTime() {
        return inqueryDateTime;
    }

    public void setInqueryDateTime(LocalDateTime inqueryDateTime) {
        this.inqueryDateTime = inqueryDateTime;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
