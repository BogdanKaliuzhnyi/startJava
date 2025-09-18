package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int number;
    private int turn;
    private int[] usedNumbers;

    Player(String name) {
        this.name = name;
        usedNumbers = new int[GuessNumber.ATTEMPTS];
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number < 1 || number > 100) {
            throw new IllegalArgumentException("Число должно входить в отрезок [1, 100]." +
                    "\nПопробуйте еще раз:");
        }
        this.number = number;
        usedNumbers[turn - 1] = number;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        turn++;
    }

    public int[] getUsedNumbers() {
        return Arrays.copyOf(usedNumbers, turn);
    }

    public void resetFields() {
        Arrays.fill(usedNumbers, 0, turn, 0);
        turn = 0;
        number = 0;
    }
}