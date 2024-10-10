package com.example.assignment_two;

public class Task {
    private String title;
    private String details;
    private boolean isCompleted;

    public Task(String title, String details) {
        this.title = title;
        this.details = details;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}