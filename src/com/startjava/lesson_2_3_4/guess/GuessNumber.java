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
        clearPlayers();
        initRound();
        Scanner sc = new Scanner(System.in);
        do {
            displayTurnInfo(player1);
            inputNumber(player1, sc);
            boolean isLastTurn = isGuessed(player1);
            if (isLastTurn) {
                displayGameEnd(isLastTurn, player1);
                displayEnteredNumbers(player1, player2);
                break;
            }
            if (player1.getCurrAttempt() == ATTEMPTS) {
                displayGameEnd(isLastTurn, player1);
            }
            System.out.println("Ход переходит к другому игроку\n");
            displayTurnInfo(player2);
            inputNumber(player2, sc);
            isLastTurn = isGuessed(player2);
            if (isLastTurn || player2.getCurrAttempt() == ATTEMPTS) {
                displayGameEnd(isLastTurn, player2);
                displayEnteredNumbers(player1, player2);
                break;
            }
        } while (true);
    }

    private void clearPlayers() {
        player1.clear();
        player2.clear();
    }

    private void initRound() {
        System.out.println("Игра началась! У каждого игрока по " + ATTEMPTS + " попыток");
        magicNumber = ThreadLocalRandom.current().nextInt(100) + 1;
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать\n");
    }

    private void displayTurnInfo(Player player) {
        System.out.println("Попытка " + (player.getCurrAttempt() + 1));
        System.out.print("Число вводит " + player.getName() + ":");
    }

    private void inputNumber(Player player, Scanner sc) {
        player.incrementCurrAttempt();
        while (true) {
            try {
                player.addNumber(sc.nextInt());
                return;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean isGuessed(Player player) {
        if (player.getLastNumber() == magicNumber) {
            return true;
        }
        System.out.println(player.getLastNumber() + (player.getLastNumber() > magicNumber ? " больше " : " меньше ") +
                "того, что загадал компьютер");
        return false;
    }

    private void displayGameEnd(boolean isGuessed, Player player) {
        if (isGuessed) {
            System.out.println("\n" + player.getName() + " угадал число " + magicNumber +
                    " с " + player.getCurrAttempt() + " попытки");
            return;
        }
        System.out.println("У " + player.getName() + " закончились попытки!");

        if (player == player2) {
            System.out.println("\nИгра окончена. Никто не угадал число " + magicNumber);
        }
    }

    private void displayEnteredNumbers(Player... players) {
        for (Player p : players) {
            System.out.print(p.getName() + " использовал числа:");
            for (int i : p.getEnteredNumbers()) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}