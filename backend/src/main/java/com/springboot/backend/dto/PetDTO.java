package com.springboot.backend.dto;

import com.springboot.backend.model.Pet;

public class PetDTO {
    private long id;
    private String name;
    private String type;
    private String breed;
    private String age;
    private String description;
    private String image;
    private long shelterId;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.type = pet.getType();
        this.breed = pet.getBreed();
        this.age = pet.getAge();
        this.description = pet.getDescription();
        this.image = pet.getImage();
        this.shelterId = pet.getShelter().getId();
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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public long getShelterId() {
        return shelterId;
    }
    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }
}
