package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    static final String ANSWER_YES = "yes";
    static final String ANSWER_NO = "no";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого игрока:");
        Player player1 = new Player(sc.nextLine());
        System.out.print("Введите имя второго игрока:");
        Player player2 = new Player(sc.nextLine());
        String answer = "yes";
        GuessNumber game = new GuessNumber(player1, player2);

        while (!ANSWER_NO.equals(answer)) {
            if (ANSWER_YES.equals(answer)) {
                game.play();
                System.out.print("\nХотите продолжить игру? [yes/no]:");
            }
            answer = sc.nextLine().toLowerCase();
            if (!ANSWER_YES.equals(answer) && !ANSWER_NO.equals(answer)) {
                System.out.print("Введите корректный ответ [yes / no]:");
            }
        }
    }
}