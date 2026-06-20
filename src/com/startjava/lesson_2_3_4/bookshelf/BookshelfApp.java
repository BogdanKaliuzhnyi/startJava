package com.startjava.lesson_2_3_4.bookshelf;

import java.time.Year;
import java.util.Scanner;

public class BookshelfApp {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_MENU_ITEM = 1;
    private static final int MAX_MENU_ITEM = 5;

    private final Bookshelf bookshelf = new Bookshelf();

    public void run() {
        showIntroduction();
        while (true) {
            showBookshelfStatistics(bookshelf.getBooksCount(), bookshelf.getFreeShelvesAmount());
            if (bookshelf.getBooksCount() > 0) {
                showBookshelf();
            }
            showMenu();
            switch (chooseMenuCommand()) {
                case 1 -> addBook();
                case 2 -> findBook();
                case 3 -> removeBook();
                case 4 -> clearBookshelf();
                case 5 -> {
                    return;
                }
                default -> {
                    continue;
                }
            }
            waitEnterInput();
        }
    }

    private void showIntroduction() {
        String text = """
                Добро пожаловать в книжный шкаф!
                На полках шкафа может храниться до 10 книг одновременно
                """;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private void showBookshelfStatistics(int books, int shelves) {
        if (books == 0) {
            printMessage("Шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }
        System.out.printf("В шкафу книг - %d, свободно полок - %d\n\n", books, shelves);
    }

    private void showMenu() {
        printMessage("""
                
                Для продолжения, выберите пункт меню:
                1. Добавить книгу
                2. Найти и получить книгу
                3. Найти и удалить книгу
                4. Очистить шкаф
                5. Завершить работу с книжным шкафом
                
                """);
    }

    private int chooseMenuCommand() {
        while (true) {
            printMessage("Выберите команду: ");
            String input = SCANNER.nextLine();
            if (input.length() != 1 || !input.matches("\\d")) {
                printInputError("значение должно быть целым числом");
                continue;
            }

            int choice = Integer.parseInt(input);
            if (choice < MIN_MENU_ITEM || choice > MAX_MENU_ITEM) {
                printInputError("неверное значение меню (" + choice + "). " +
                        "Допустимые значения: " + MIN_MENU_ITEM + "-" + MAX_MENU_ITEM);
                continue;
            }
            return choice;
        }
    }

    private void showBookshelf() {
        Book[] books = bookshelf.getAllBooks();
        int shelvesWidth = bookshelf.getShelvesWidth();
        for (Book book : books) {
            String bookDescription = book.toString();
            printMessage("|" + bookDescription + " ".repeat(shelvesWidth - bookDescription.length()) + "|\n");
            printMessage("|" + "-".repeat(shelvesWidth) + "|\n");
        }
        printMessage("|" + " ".repeat(shelvesWidth) + "|\n");
    }

    private void waitEnterInput() {
        printMessage("Для продолжения работы нажмите клавишу <Enter>");
        while (!SCANNER.nextLine().isEmpty()) {
            printInputError("необходимо нажать только клавишу <Enter>");
        }
    }

    private void addBook() {
        if (bookshelf.getFreeShelvesAmount() == 0) {
            printInputError("Нельзя добавить книгу, шкаф переполнен");
            return;
        }

        String author = requestInput("автора");
        String title = requestInput("название");
        Year publishedYear;
        while (true) {
            try {
                publishedYear = parsePublishedYear(requestInput("год издания"));
                if (publishedYear == null) {
                    printInputError("год издания должен быть между 1800 и текущим");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                printInputError("год издания должен быть указан в формате YYYY\n");
            }
        }

        boolean isAdded;
        try {
            Book book = new Book(author, title, publishedYear);
            isAdded = bookshelf.addBook(book);
        } catch (IllegalArgumentException e) {
            printInputError("Ошибка! " + e.getMessage());
            return;
        }

        if (isAdded) {
            printMessage("Добавлена книга: \"" + author + ", " + title + ", " + publishedYear + "\"\n");
        } else {
            printInputError("В шкафу нет свободного места. Книга не была добавлена");
        }
    }

    private Year parsePublishedYear(String yearAsString) {
        Year year = Year.of(Integer.parseInt(yearAsString));
        return Book.isPublishedYearInRange(year) ? year : null;
    }

    private void findBook() {
        Book book = bookshelf.findBook(requestInput("название"));
        if (book == null) {
            printInputError("книга с таким названием не найдена на полках шкафа");
            return;
        }
        printMessage("Выдана книга: " + book + '\n');
    }

    private void removeBook() {
        if (bookshelf.removeBook(requestInput("название"))) {
            printMessage("Книга успешно удалена\n");
            return;
        }
        printInputError("книга с таким названием не найдена на полках шкафа");
    }

    private void clearBookshelf() {
        bookshelf.clear();
        printMessage("Шкаф очищен\n");
    }

    private String requestInput(String arg) {
        printMessage("Введите " + arg + " книги: ");
        return SCANNER.nextLine();
    }

    private void printInputError(String errorText) {
        System.out.println("Ошибка: " + errorText);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }
}