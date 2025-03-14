package com.microservices.library.bookborrowing.entities;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private int id;

    private String title;

    private String author;

    public Book() {}

    public Book(String title, int id, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
