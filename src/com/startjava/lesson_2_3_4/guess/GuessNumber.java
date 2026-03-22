package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    private static final int ROUNDS_AMOUNT = 3;
    static final int ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;

    private final Player[] players;
    private final Scanner scanner;

    private int currRound;
    private int magicNumber;

    GuessNumber(Player[] players, Scanner scanner) {
        this.players = players;
        this.scanner = scanner;
        currRound = 1;
    }

    public void play() {
        initGame();
        do {
            playNewRound();
        } while (currRound <= ROUNDS_AMOUNT);
        determineWinner();
    }

    private void initGame() {
        clearPlayersWins();
        shufflePlayersOrder(players);
        System.out.printf("""
                Игра началась! Победитель определяется по итогам проведения %d раундов
                У каждого игрока по %d попыток в раунде""", ROUNDS_AMOUNT, ATTEMPTS);
    }

    private void clearPlayersWins() {
        for (Player p : players) {
            p.clearWins();
        }
    }

    private void shufflePlayersOrder(Player[] players) {
        for (int i = players.length - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[j];
            players[j] = temp;
        }

        char[] spins = {'—', '\\', '|', '/'};
        for (int i = 0; i < spins.length * 3; i++) {
            System.out.print("Определяется очередность: " + spins[i % spins.length] + '\r');
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Игроки угадывают в следующем порядке:");
        for (int i = 0; i < players.length; i++) {
            System.out.println((i + 1) + ". " + players[i].getName());
        }
    }

    private void playNewRound() {
        initRound();
        boolean isGuessed = false;
        for (int i = 0; i < ATTEMPTS && !isGuessed; i++) {
            for (Player p : players) {
                displayTurnInfo(p);
                inputNumber(p);
                isGuessed = isGuessed(p);
                if (isGuessed) {
                    break;
                }
                if (p.getCurrAttempt() == ATTEMPTS) {
                    System.out.println("У " + p.getName() + " закончились попытки!");
                }
            }
        }

        if (!isGuessed) {
            System.out.println("\nРаунд закончен. Никто не угадал число " + magicNumber);
        }
        displayEnteredNumbers();
    }

    private void initRound() {
        clearPlayersAttempts();
        magicNumber = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
        System.out.println("\nРаунд " + currRound++);
        System.out.printf("Загадано число от %d до %d, попробуйте его угадать %n", MIN_NUMBER, MAX_NUMBER);
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
                return;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
                System.out.println("\nПопробуйте еще раз: ");
            }
        }
    }

    private boolean isGuessed(Player player) {
        boolean guessed = player.getLastNumber() == magicNumber;
        if (guessed) {
            System.out.println("\n" + player.getName() + " угадал число " + magicNumber +
                    " c " + player.getCurrAttempt() + "-й попытки");
            player.increaseWins();
        }
        int lastNumber = player.getLastNumber();
        System.out.println(lastNumber + (lastNumber > magicNumber ? " больше " : " меньше ") +
                "того, что загадал компьютер");
        return guessed;
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