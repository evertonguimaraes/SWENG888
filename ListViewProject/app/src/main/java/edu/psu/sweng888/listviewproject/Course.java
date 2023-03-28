package edu.psu.sweng888.listviewproject;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;
    private int credits;
    private String description;

    public Course(int id, int credits, String description) {
        this.id = id;
        this.credits = credits;
        this.description = description;
    }

    // Getter and Setter methods for the class attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
