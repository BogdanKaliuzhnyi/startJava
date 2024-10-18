package lesson_1;

import java.util.Scanner;

public class MyFirstGame {
    public static void main(String[] args) {
        int magicNumber = (int) (Math.random() * 100) + 1;
        System.out.println("Я загадал число от 1 до 100, попробуй его угадать");
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (magicNumber != number) {
            System.out.print("Введи число: ");
            number = sc.nextInt();
            System.out.println(number + (number > magicNumber ? " больше " : " меньше ") +
                    "того, что загадал компьютер");
        }
        System.out.println("Вы победили!");
    }
}
