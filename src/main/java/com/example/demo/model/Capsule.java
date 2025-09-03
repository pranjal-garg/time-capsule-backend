package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Map;

public class Capsule {

    private int capsuleId;
    private Map<String, String> data;
    private boolean isLocked;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    public Capsule(int capsuleId, Map<String, String> data, LocalDate endDate,  boolean isLocked) {
        this.capsuleId = capsuleId;
        this.data = data;
        this.endDate = endDate;
        this.isLocked = isLocked;
    }

    public int getCapsuleId() {
        return capsuleId;
    }

    public void setCapsuleId(int capsuleId) {
        this.capsuleId = capsuleId;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void isLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void updateCapsule(Capsule capsule) {
        this.capsuleId = capsule.getCapsuleId();
        this.data = capsule.getData();
        this.endDate = capsule.getEndDate();
        this.startDate = capsule.getStartDate();
        this.isLocked = capsule.isLocked();
    }
}
