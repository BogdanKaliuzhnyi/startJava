package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String repeat;
        Calculator calculator = new Calculator();

        do {
            System.out.print("Введите первое число: ");
            int a = sc.nextInt();
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            char sign = sc.next().charAt(0);
            System.out.print("Введите второе число: ");
            int b = sc.nextInt();
            calculator.calculate(a, sign, b);

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                repeat = sc.next().toLowerCase();
            } while (!repeat.equals("yes") && !repeat.equals("no"));
        } while (repeat.equals("yes"));
    }
}