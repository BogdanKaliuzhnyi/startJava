package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int currAttempt;
    private int[] enteredNumbers;

    Player(String name) {
        this.name = name;
        enteredNumbers = new int[GuessNumber.ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getLastNumber() {
        return enteredNumbers[currAttempt - 1];
    }

    public void addNumber(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз:");
        }
        enteredNumbers[currAttempt - 1] = number;
    }

    public int getCurrAttempt() {
        return currAttempt;
    }

    public void incrementCurrAttempt() {
        currAttempt++;
    }

    public int[] getEnteredNumbers() {
        return Arrays.copyOf(enteredNumbers, currAttempt);
    }

    public void clear() {
        Arrays.fill(enteredNumbers, 0, currAttempt, 0);
        currAttempt = 0;
    }
}