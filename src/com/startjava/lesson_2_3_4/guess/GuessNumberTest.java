package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    static final String ANSWER_YES = "yes";
    static final String ANSWER_NO = "no";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество игроков для начала игры: ");
        int playersQuantity = Integer.parseInt(sc.nextLine());
        Player[] players = createPlayers(sc, playersQuantity);
        GuessNumber game = new GuessNumber(players, sc);
        String answer = ANSWER_YES;
        while (!ANSWER_NO.equals(answer)) {
            if (ANSWER_YES.equals(answer)) {
                game.play();
                System.out.print("\nХотите продолжить игру? [yes/no]: ");
            }
            answer = sc.nextLine().toLowerCase();
            if (!ANSWER_YES.equals(answer) && !ANSWER_NO.equals(answer)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        }
    }

    private static Player[] createPlayers(Scanner sc, int playersQuantity) {
        Player[] players = new Player[playersQuantity];
        for (int i = 0; i < players.length; i++) {
            System.out.print("Введите имя " + (i + 1) + "-го игрока: ");
            players[i] = new Player(sc.nextLine());
        }
        return players;
    }
}