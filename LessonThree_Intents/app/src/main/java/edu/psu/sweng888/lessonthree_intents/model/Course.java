package edu.psu.sweng888.lessonthree_intents.model;

import java.io.Serializable;

public class Course implements Serializable {

    private int courseID;
    private int numberOfCredits;
    private String courseDescription;

    public Course(int courseID, int numberOfCredits, String courseDescription) {
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.courseDescription = courseDescription;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
