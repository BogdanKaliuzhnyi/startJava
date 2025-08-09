package com.startjava.lesson_2_3_4.hangman;
import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";
        do {
            if (answer.equalsIgnoreCase("yes")) {
                HangmanGame game = new HangmanGame();
                game.play(sc);
            }
            answer = sc.nextLine().toLowerCase();
            if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                System.out.print("Введите корректный ответ [yes / no]:");
            }

        } while (!answer.equalsIgnoreCase("no"));
    }
}
