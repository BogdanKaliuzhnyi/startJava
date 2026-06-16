package com.startjava.lesson_2_3_4.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int booksCount;
    private int maxShelfWidth;

    public Book[] getAllBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getFreeShelvesAmount() {
        return CAPACITY - booksCount;
    }

    public int getMaxShelvesAmount() {
        return maxShelfWidth;
    }

    public boolean addBook(Book book) {
        if (booksCount < CAPACITY) {
            books[booksCount++] = book;
            calculateMaxShelfWidth();
            return true;
        }
        return false;
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

        System.arraycopy(books, bookIndex + 1, books, bookIndex, booksCount - bookIndex - 1);
        books[booksCount - 1] = null;
        booksCount--;
        calculateMaxShelfWidth();
        return true;
    }

    public void clear() {
        Arrays.fill(books, null);
        calculateMaxShelfWidth();
        booksCount = 0;
    }

    private int findBookIndex(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (title != null && title.equalsIgnoreCase(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private void calculateMaxShelfWidth() {
        for (Book book : books) {
            if (book == null) {
                return;
            }
            maxShelfWidth = Math.max(maxShelfWidth, book.toString().length());
        }
    }
}