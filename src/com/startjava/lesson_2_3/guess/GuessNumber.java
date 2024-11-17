package com.startjava.lesson_2_3.guess;

import java.util.Scanner;

public class GuessNumber {

    private int magicNumber;
    private Player player1;
    private Player player2;

    GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        magicNumber = (int) (Math.random() * 100) + 1;
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать");
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        do {
            inputNumber(player1, sc);
            if (isGuessed(player1)) {
                break;
            }
            inputNumber(player2, sc);
        } while (!isGuessed(player2));
    }

    private void inputNumber(Player player, Scanner sc) {
        System.out.print(player.getName() + " введи число: ");
        player.setNumber(sc.nextInt());
    }

    private boolean isGuessed(Player player) {
        if (player.getNumber() == magicNumber) {
            System.out.println("Игрок " + player.getName() + " победил!");
            return true;
        }
        System.out.println(player.getNumber() + (player.getNumber() > magicNumber ? " больше " : " меньше ") +
                "того, что загадал компьютер");
        System.out.println("Ход переходит к другому игроку");
        return false;
    }
}
