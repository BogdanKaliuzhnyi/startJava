package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksCount;
    private int shelvesWidth;

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getFreeShelvesAmount() {
        return CAPACITY - booksCount;
    }

    public int getShelvesWidth() {
        return shelvesWidth;
    }

    public boolean addBook(Book book) {
        if (book != null && booksCount == CAPACITY) {
            return false;
        }
        books[booksCount++] = book;
        shelvesWidth = Math.max(shelvesWidth, book.toString().length());
        return true;
    }

    public Book findBook(String title) {
        int bookIndex = findBookIndex(title);
        return bookIndex == -1 ? null : books[bookIndex];
    }

    public boolean removeBook(String title) {
        int bookIndex = findBookIndex(title);
        if (bookIndex == -1) {
            return false;
        }
        int removableBookWidth = books[bookIndex].toString().length();
        System.arraycopy(books, bookIndex + 1, books, bookIndex, booksCount - bookIndex - 1);
        books[booksCount - 1] = null;
        booksCount--;
        if (removableBookWidth == shelvesWidth) {
            calculateMaxShelvesWidth();
        }
        return true;
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        shelvesWidth = 0;
        booksCount = 0;
    }

    private int findBookIndex(String title) {
        if (title == null || title.isBlank()) {
            return -1;
        }

        for (int i = 0; i < booksCount; i++) {
            if (title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private void calculateMaxShelvesWidth() {
        shelvesWidth = 0;
        for (int i = 0; i < booksCount; i++) {
            shelvesWidth = Math.max(shelvesWidth, books[i].toString().length());
        }
    }
}