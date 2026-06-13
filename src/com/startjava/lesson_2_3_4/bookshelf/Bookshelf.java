package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int BOOKSHELF_CAPACITY = 10;
    private Book[] books = new Book[BOOKSHELF_CAPACITY];
    private int booksCount;

    public boolean addBook(Book book) {
        if (booksCount < BOOKSHELF_CAPACITY) {
            books[booksCount++] = book;
            return true;
        }
        return false;
    }

    public Book findBook(String title) {
        int bookIndex = findBookIndex(title);
        if (bookIndex == -1) {
            return null;
        }
        return books[bookIndex];
    }

    public boolean removeBook(String title) {
        int bookIndex = findBookIndex(title);
        if (bookIndex == -1) {
            return false;
        }

        if (bookIndex < booksCount - 1) {
            System.arraycopy(books, bookIndex + 1, books, bookIndex, booksCount - bookIndex - 1);
            books[booksCount - 1] = null;
        } else {
            books[bookIndex] = null;
        }
        booksCount--;
        return true;
    }

    public void clear() {
        books = new Book[BOOKSHELF_CAPACITY];
        booksCount = 0;
    }

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getFreeShelvesAmount() {
        return BOOKSHELF_CAPACITY - booksCount;
    }

    private int findBookIndex(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (title != null || title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }
}