package lesson_2;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(sc.nextLine());
        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(sc.nextLine());
        String repeat;

        do {
            GuessNumber game = new GuessNumber();
            while (!game.isGuessed) {
                System.out.print(player1.getName() + " введи число: ");
                player1.setNumber(sc.nextInt());
                game.playGame(player1);
                if (game.isGuessed) {
                    break;
                }
                System.out.print(player2.getName() + " введи число: ");
                player2.setNumber(sc.nextInt());
                game.playGame(player2);
            }
            do {
                System.out.println("Хотите продолжить игру? [yes/no]:");
                repeat = sc.next().toLowerCase();
            } while (!repeat.equals("yes") && !repeat.equals("no"));
        } while (repeat.equals("yes"));
    }
}
