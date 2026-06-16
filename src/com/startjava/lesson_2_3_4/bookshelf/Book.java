package com.startjava.lesson_2_3_4.bookshelf;

import java.time.Year;

public class Book {
    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String author, String title, Year publishedYear) {
        this.author = throwIfInvalid(author, "<Автор>");
        this.title = throwIfInvalid(title, "<Название>");
        if (publishedYear == null) {
            throw new IllegalArgumentException("Год издания не может быть null");
        }
        this.publishedYear = publishedYear;
    }

    private String throwIfInvalid(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " не может быть null или пустым");
        }
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return author + ", " + title + ", " + publishedYear;
    }
}