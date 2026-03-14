package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    static final int ATTEMPTS = 10;
    static final int ROUNDS_AMOUNT = 3;
    private int currentRound;
    private int magicNumber;
    private final Player[] players;
    private final Scanner scanner;

    GuessNumber(Player[] players, Scanner scanner) {
        this.players = players;
        this.scanner = scanner;
    }

    public void play() throws InterruptedException {
        initiateGame();
        do {
            playNewRound();
        } while (currentRound <= ROUNDS_AMOUNT);
        determineWinner();
    }

    private void initiateGame() throws InterruptedException {
        clearPlayersWins();
        setPlayersOrder(players);
        currentRound = 1;
        System.out.println("Игра началась! Победитель определяется по итогам проведения " + ROUNDS_AMOUNT + " раундов");
        System.out.println("У каждого игрока по " + ATTEMPTS + " попыток в раунде");
    }

    private void clearPlayersWins() {
        for (Player p : players) {
            p.clearWins();
        }
    }

    private void setPlayersOrder(Player[] players) throws InterruptedException {
        for (int i = players.length - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }

        char[] spins = {'-', '\\', '|', '/'};
        for (int i = 0; i < 3; i++) {
            for (char symbol : spins) {
                System.out.print("Определяется очередность: " + symbol);
                System.out.print('\r');
                Thread.sleep(200);
            }
        }

        System.out.println("Игроки угадывают в следующем порядке:");
        for (int i = 0; i < players.length; i++) {
            System.out.println((i + 1) + ". " + players[i].getName());
        }
    }

    private void playNewRound() {
        initiateRound();
        boolean isGuessed = false;
        for (int i = 0; i < ATTEMPTS && !isGuessed; i++) {
            for (int j = 0; j < players.length; j++) {
                Player p = players[j];
                displayTurnInfo(p);
                inputNumber(p);
                if (isGuessed(p)) {
                    showRoundEnding(p);
                    isGuessed = true;
                    break;
                }

                if (p.getCurrAttempt() == ATTEMPTS) {
                    System.out.println("У " + p.getName() + " закончились попытки!");
                }

                if (j < players.length - 1) {
                    System.out.println("Ход переходит к другому игроку");
                }
            }
        }

        if (!isGuessed) {
            System.out.println("\nРаунд закончен. Никто не угадал число " + magicNumber);
        }
        displayEnteredNumbers();
    }

    private void initiateRound() {
        clearPlayersAttempts();
        magicNumber = ThreadLocalRandom.current().nextInt(100) + 1;
        System.out.println("\nРаунд " + currentRound++);
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать");
    }

    private void clearPlayersAttempts() {
        for (Player p : players) {
            p.clearAttempts();
        }
    }

    private void displayTurnInfo(Player player) {
        System.out.println("\nПопытка " + (player.getCurrAttempt() + 1));
        System.out.print("Число вводит " + player.getName() + ": ");
    }

    private void inputNumber(Player player) {
        while (true) {
            try {
                player.addNumber(scanner.nextInt());
                scanner.nextLine();
                player.increaseCurrAttempt();
                return;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private boolean isGuessed(Player player) {
        int lastNumber = player.getLastNumber();
        if (lastNumber == magicNumber) {
            player.increaseWins();
            return true;
        }
        System.out.println(lastNumber + (lastNumber > magicNumber ? " больше " : " меньше ") +
                "того, что загадал компьютер");
        return false;
    }

    private void showRoundEnding(Player player) {
        System.out.println("\n" + player.getName() + " угадал число " + magicNumber +
                " c " + player.getCurrAttempt() + "-й попытки");
    }

    private void displayEnteredNumbers() {
        for (Player p : players) {
            System.out.print(p.getName() + " использовал числа:");
            for (int i : p.getEnteredNumbers()) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    private void determineWinner() {
        System.out.println("\nПо итогам " + ROUNDS_AMOUNT + " раундов, итоговые очки:");
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getWins());
        }

        int maxWins = 0;
        for (Player p : players) {
            maxWins = Math.max(maxWins, p.getWins());
        }

        if (maxWins == 0) {
            System.out.println("Победителя нет");
            return;
        }

        Player winner = null;
        int samePointsCount = 0;
        for (Player p : players) {
            if (p.getWins() == 0) {
                continue;
            }
            if (p.getWins() == maxWins) {
                samePointsCount++;
                winner = p;
            }
        }

        boolean isDraw = samePointsCount > 1;
        if (isDraw) {
            System.out.print("Ничья! У игроков:");
            for (Player p : players) {
                if (p.getWins() == maxWins) {
                    System.out.print(" " + p.getName());
                }
            }
            System.out.println(" одинаковое количество очков");
            return;
        }

        System.out.println("Победил " + winner.getName());
    }
}