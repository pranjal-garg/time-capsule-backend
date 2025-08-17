package com.example.demo.model;

public class Capsule {

    private int capsuleId;
    private String title;
    private String  message;
    private String startDate;
    private String endDate;


    public Capsule(int capsuleId, String title, String message,  String startDate, String endDate) {
        this.capsuleId = capsuleId;
        this.title = title;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getCapsuleId() {
        return capsuleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCapsuleId(int capsuleId) {
        this.capsuleId = capsuleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
