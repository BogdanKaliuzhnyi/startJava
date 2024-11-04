package lesson_2;

import java.util.Scanner;

public class GuessNumber {

    int magicNumber;
    public boolean isRunning;

    GuessNumber() {
        magicNumber = (int) (Math.random() * 100) + 1;
        isRunning = false;
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать");
    }

    public void play(Player player1, Player player2) {
        while (!isRunning) {
            inputNumber(player1);
            if (isGuessed(player1)) {
                return;
            }
            inputNumber(player2);
            isGuessed(player2);
        }
    }

    private void inputNumber(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.print(player.getName() + " введи число: ");
        player.setNumber(sc.nextInt());
    }

    private boolean isGuessed(Player player) {
        if (player.getNumber() != magicNumber) {
            System.out.println(player.getNumber() + (player.getNumber() > magicNumber ? " больше " : " меньше ") +
                    "того, что загадал компьютер");
            System.out.println("Ход переходит к другому игроку");
            return false;
        }
        System.out.println("Игрок " + player.getName() + " победил!");
        isRunning = true;
        return true;
    }
}
