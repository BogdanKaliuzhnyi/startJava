package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                Calculator calculator = new Calculator();
                calculator.startCalculating(sc);
                System.out.print("Хотите продолжить вычисления? [yes / no]: ");
            }
            answer = sc.nextLine();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        } while (!answer.equals("no"));
    }
}