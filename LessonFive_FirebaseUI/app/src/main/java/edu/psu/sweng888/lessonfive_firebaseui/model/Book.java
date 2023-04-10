package edu.psu.sweng888.lessonfive_firebaseui.model;

import java.io.Serializable;

public class Book implements Serializable {
    
    private String title;
    private String author;
    private String publisher;
    private String publicationData;
    private String codeISBN;

    public Book() {
    }

    public Book(String title, String author, String publisher, String publicationData, String codeISBN) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationData = publicationData;
        this.codeISBN = codeISBN;
    }

    /** Getters and Setters */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationData;
    }

    public void setPublicationData(String publicationData) {
        this.publicationData = publicationData;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public void setCodeISBN(String codeISBN) {
        this.codeISBN = codeISBN;
    }
}
