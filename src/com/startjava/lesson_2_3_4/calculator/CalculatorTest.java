package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";

        while (!"no".equalsIgnoreCase(answer)) {
            if ("yes".equalsIgnoreCase(answer)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String expression = sc.nextLine();
                try {
                    printCalculationResult(expression, Calculator.calculate(expression));
                } catch (Calculator.CalculatorException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("Хотите продолжить вычисления? [yes / no]: ");
            }

            answer = sc.nextLine();
            if (!"yes".equalsIgnoreCase(answer) && !"no".equalsIgnoreCase(answer)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        }
    }

    private static void printCalculationResult(String expression, double result) {
        System.out.println(expression + " = " + new DecimalFormat("#.###").format(result));
    }
}