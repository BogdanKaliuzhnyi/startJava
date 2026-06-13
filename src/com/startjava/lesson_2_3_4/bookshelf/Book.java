package com.startjava.lesson_2_3_4.bookshelf;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year publicationYear;

    public Book(String author, String title, Year publicationYear) {
        this.author = validateStringField(author, "<Автор>");
        this.title = validateStringField(title, "<Название>");
        if (publicationYear == null) {
            throw new IllegalArgumentException("Год издания не может быть null");
        }
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title + ", " + publicationYear;
    }

    private String validateStringField(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Поле " + fieldName + " не может быть null или пустым");
        }
        return value;
    }
}