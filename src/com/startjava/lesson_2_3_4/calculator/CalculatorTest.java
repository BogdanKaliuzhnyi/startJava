package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                Calculator calculator = new Calculator();
                String expression = sc.nextLine();
                printExpressionResult(expression, calculator.calculate(expression));
                System.out.print("Хотите продолжить вычисления? [yes / no]: ");
            }
            answer = sc.nextLine();
            if (!answer.equals("yes") && !answer.equals("no")) {
                System.out.print("Введите корректный ответ [yes / no]: ");
            }
        } while (!answer.equals("no"));
    }

    private static void printExpressionResult(String expression, double result) {
        if (!Double.isNaN(result)) {
            System.out.println(expression + " = " + new DecimalFormat("#.###").format(result));
        }
    }
}