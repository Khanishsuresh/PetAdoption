package com.springboot.backend.dto;

public class ShelterPerTypeDTO {
    private long shelterId;
    private String type;
    private long type_count;

    public ShelterPerTypeDTO(long shelterId , String type , long type_count) {
        this.shelterId = shelterId;
        this.type = type;
        this.type_count = type_count;
    }

    //Getters and Setters
    public long getShelterId() {
        return shelterId;
    }
    public void setShelterID(long shelterId) {
        this.shelterId = shelterId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getType_count() {
        return type_count;
    }
    public void setType_count(long type_count) {
        this.type_count = type_count;
    }
}
