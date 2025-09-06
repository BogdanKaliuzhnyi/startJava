package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    final static String ANSWER_YES = "yes";
    final static String ANSWER_NO = "no";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";

        while (!ANSWER_NO.equalsIgnoreCase(answer)) {
            if (ANSWER_YES.equalsIgnoreCase(answer)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String expr = sc.nextLine().trim().replaceAll("\\s+", " ");
                try {
                    printCalculationResult(expr, Calculator.calculate(expr));
                } catch (UnexpectedInputException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("Хотите продолжить вычисления? [yes / no]: ");
            }

            answer = sc.nextLine();
            if (!ANSWER_YES.equalsIgnoreCase(answer) && !ANSWER_NO.equalsIgnoreCase(answer)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        }
    }

    private static void printCalculationResult(String expr, double result) {
        System.out.println(expr + " = " + new DecimalFormat("#.###").format(result));
    }
}