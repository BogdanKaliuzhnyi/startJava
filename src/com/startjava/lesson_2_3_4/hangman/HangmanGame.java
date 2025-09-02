package com.startjava.lesson_2_3_4.hangman;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class HangmanGame {
    private final String[] gallows =
      {"_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
      };
    private final String[] guessWords = {"ДРУЖБА", "АВТОМОБИЛЬ", "ГИТАРА", "МОРКОВЬ", "КОСМОС"};

    private enum Statuses {
        END,
        TURN
    }

    private Statuses currentStatus;
    private int remainingAttempts;
    private int movesCount;
    private int mismatchesCount;
    private final char[] usedLetters;
    private final char[] wrongLetters;
    private final char[] riddledLetters;
    private final char[] hiddenRiddledWord;

    public HangmanGame() {
        currentStatus = Statuses.TURN;
        riddledLetters = randomizeWord();
        hiddenRiddledWord = createMask(riddledLetters);
        remainingAttempts = gallows.length;
        wrongLetters = new char[riddledLetters.length + remainingAttempts - 1];
        usedLetters = new char[riddledLetters.length + wrongLetters.length - 1];
    }

    private char[] randomizeWord() {
        Random random = new Random();
        return guessWords[random.nextInt(guessWords.length)].toCharArray();
    }

    private char[] createMask(char[] word) {
        char[] guessedWord = new char[word.length];
        Arrays.fill(guessedWord, '_');
        return guessedWord;
    }

    void play(Scanner sc) {
        displayTurnInfo();
        String input;
        do {
            input = sc.nextLine();
            char letter = input.toUpperCase().charAt(0);
            if (!isValidLetter(letter)) {
                continue;
            }
            usedLetters[movesCount++] = letter;
            compareLetter(letter);

            if (Arrays.equals(riddledLetters, hiddenRiddledWord) || remainingAttempts == 0) {
                currentStatus = Statuses.END;
            }
            displayTurnInfo();
        } while (currentStatus != Statuses.END);
        displayTurnInfo();
        System.out.println((remainingAttempts == 0 ? "\nК сожалению, ты проиграл"
                : "\nПобеда! Ты отгадал слово"));
    }

    private void displayTurnInfo() {
        System.out.print("\nЗагаданное слово: ");
        if (remainingAttempts > 0) {
            for (char c : hiddenRiddledWord) {
                System.out.print(c);
            }
        } else {
            for (char c : riddledLetters) {
                System.out.print(c);
            }
        }

        System.out.println("\nОсталось попыток: " + remainingAttempts);
        displayGallows();
        System.out.print("Ошибочные буквы: ");
        for (char wrongLetter : wrongLetters) {
            if (wrongLetter == '\u0000') {
                break;
            }
            System.out.print(wrongLetter + " ");
        }
        if (currentStatus != Statuses.END) {
            System.out.print("\nВведи предполагаемую букву:");
        }
    }

    private boolean isValidLetter(char letter) {
        if (letter < 'А' || letter > 'Я') {
            System.out.print("Введена недопустимая буква. Используй любую букву от 'A' до 'Я':");
            return false;
        }

        for (int i = 0; i < movesCount; i++) {
            if (usedLetters[i] == letter) {
                System.out.print("Буква " + letter + " раннее была введена, попробуй другую букву:");
                return false;
            }
        }
        currentStatus = Statuses.TURN;
        return true;
    }

    private void compareLetter(char letter) {
        boolean isMatched = false;
        for (int i = 0; i < riddledLetters.length; i++) {
            if (letter == riddledLetters[i]) {
                hiddenRiddledWord[i] = letter;
                isMatched = true;
            }
        }

        if (isMatched) {
            if (remainingAttempts < gallows.length) {
                remainingAttempts++;
            }
            System.out.println("Ты угадал");
            return;
        }

        wrongLetters[mismatchesCount++] = letter;
        remainingAttempts--;
        System.out.println("Ты не угадал");
    }

    private void displayGallows() {
        if (remainingAttempts >= 0) {
            for (int i = 0; i < gallows.length - remainingAttempts; i++) {
                System.out.println(gallows[i]);
            }
        }
    }
}