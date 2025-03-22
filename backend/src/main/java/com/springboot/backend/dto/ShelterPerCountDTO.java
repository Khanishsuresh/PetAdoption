package com.springboot.backend.dto;

public class ShelterPerCountDTO {
    private long shelterId;
    private long count;

    public ShelterPerCountDTO(long shelterId, long count) {
        this.shelterId = shelterId;
        this.count = count;
    }

    //Getters and Setters
    public long getShelterId() {
        return shelterId;
    }
    public void setShelterID(long shelterId) {
        this.shelterId = shelterId;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
}
