package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    static final int ATTEMPTS = 10;
    private int magicNumber;
    private Player player1;
    private Player player2;

    GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        startNewGame(player1, player2);
        Scanner sc = new Scanner(System.in);
        do {
            displayTurnInfo(player1);
            inputNumber(player1, sc);
            if (isGuessed(player1)) {
                break;
            }
            displayTurnInfo(player2);
            inputNumber(player2, sc);
        } while (!isGuessed(player2));
    }

    private void startNewGame(Player player1, Player player2) {
        player1.resetFields();
        player2.resetFields();
        System.out.println("Игра началась! У каждого игрока по " + ATTEMPTS + " попыток");
        magicNumber = ThreadLocalRandom.current().nextInt(100) + 1;
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать");
    }

    private void inputNumber(Player player, Scanner sc) {
        player.nextTurn();
        while (true) {
            try {
                player.setNumber(sc.nextInt());
                return;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean isGuessed(Player player) {
        if (player.getNumber() == magicNumber) {
            displayGameEnd(true, player);
            displayUsedNumbers(player1, player2);
            return true;
        }
        System.out.println("\n" + player.getNumber() + (player.getNumber() > magicNumber ? " больше " : " меньше ") +
                "того, что загадал компьютер");
        if (player.getTurn() == ATTEMPTS) {
            displayGameEnd(false, player);
            if (player == player2) {
                return true;
            }
        }
        System.out.println("Ход переходит к другому игроку\n");
        return false;
    }

    private void displayTurnInfo(Player player) {
        System.out.println("Попытка " + (player.getTurn() + 1));
        System.out.print("Число вводит " + player.getName() + ":");
    }

    private void displayGameEnd(boolean isGuessed, Player player) {
        if (isGuessed) {
            System.out.println("\n" + player.getName() + " угадал число " + magicNumber +
                    " с " + player.getTurn() + " попытки");
            return;
        }
        System.out.println("У " + player.getName() + " закончились попытки!");

        if (player == player2) {
            System.out.println("\nИгра окончена. Никто не угадал число " + magicNumber);
            displayUsedNumbers(player1, player2);
        }
    }

    private void displayUsedNumbers(Player player1, Player player2) {
        System.out.print(player1.getName() + " использовал числа:");
        for (int i : player1.getUsedNumbers()) {
            System.out.print(" " + i);
        }

        System.out.print("\n" + player2.getName() + " использовал числа:");
        for (int i : player2.getUsedNumbers()) {
            System.out.print(" " + i);
        }
    }
}