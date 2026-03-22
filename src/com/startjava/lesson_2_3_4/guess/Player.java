package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

import static com.startjava.lesson_2_3_4.guess.GuessNumber.*;

public class Player {
    private final String name;
    private final int[] enteredNumbers;

    private int currAttempt;
    private int wins;

    Player(String name) {
        this.name = name;
        enteredNumbers = new int[GuessNumber.ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public int getLastNumber() {
        return enteredNumbers[currAttempt - 1];
    }

    public void addNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно входить в отрезок " +
                    "[" + MIN_NUMBER + ", " + MAX_NUMBER + "].");
        }
        enteredNumbers[currAttempt++] = number;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(enteredNumbers, currAttempt);
    }

    public int getWins() {
        return wins;
    }

    public void increaseWins() {
        wins++;
    }

    public void clearWins() {
        wins = 0;
    }

    public void clearAttempts() {
        Arrays.fill(enteredNumbers, 0, currAttempt, 0);
        currAttempt = 0;
    }
}