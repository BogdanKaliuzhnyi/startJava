package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private final String name;
    private int currAttempt;
    private final int[] enteredNumbers;
    private int wins = 0;

    Player(String name) {
        this.name = name;
        this.currAttempt = 0;
        enteredNumbers = new int[GuessNumber.ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public void increaseCurrAttempt() {
        currAttempt++;
    }

    public int getLastNumber() {
        return enteredNumbers[currAttempt - 1];
    }

    public void addNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз: ");
        }
        enteredNumbers[currAttempt] = number;
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

    public void clearAttempts() {
        Arrays.fill(enteredNumbers, 0, currAttempt, 0);
        currAttempt = 0;
    }

    public void clearWins() {
        wins = 0;
    }
}