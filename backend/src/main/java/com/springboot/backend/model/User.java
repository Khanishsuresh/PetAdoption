package com.springboot.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String Role;

    public User() {}

    public User(String Name , String Email , String Password , String Role){
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
    }

    // Getter and Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }

    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        this.Role = role;
    }
}
