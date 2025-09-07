package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    static final String ANSWER_YES = "yes";
    static final String ANSWER_NO = "no";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";

        while (!ANSWER_NO.equals(answer)) {
            if (ANSWER_YES.equals(answer)) {
                System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
                String expr = normalizeExprFormat(sc);
                try {
                    printCalculationResult(expr, Calculator.calculate(expr));
                } catch (UnexpectedInputException | IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("Хотите продолжить вычисления? [yes / no]: ");
            }

            answer = sc.nextLine().toLowerCase();
            if (!ANSWER_YES.equals(answer) && !ANSWER_NO.equals(answer)) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        }
    }

    private static String normalizeExprFormat(Scanner sc) {
        return sc.nextLine().trim().replaceAll("\\s+", " ");
    }

    private static void printCalculationResult(String expr, double result) {
        System.out.println(expr + " = " + new DecimalFormat("#.###").format(result));
    }
}