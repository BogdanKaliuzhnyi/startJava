package com.startjava.lesson_2_3_4.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public void startCalculating(Scanner sc) {
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
        String expression = sc.nextLine();
        String[] splitExpression = expression.split(" ");
        if (!isValidExpression(splitExpression)) {
            return;
        }

        double a = Double.parseDouble(splitExpression[0]);
        double b = Double.parseDouble(splitExpression[2]);
        char sign = splitExpression[1].charAt(0);
        double result = calculate(a, b, sign);

        if (Double.isNaN(result)) {
            return;
        }

        System.out.println(expression + " = " + new DecimalFormat("#.###").format(result));
    }

    private boolean isValidExpression(String[] splitExp) {
        if (splitExp.length != 3) {
            System.out.println("Ошибка: введенные данные не соответствуют установленному формату " +
                    "\"Число_Пробел_ЗнакМатематическойОперации_Пробел_Число\"");
            return false;
        }
        return isNumber(splitExp[0]) && isNumber(splitExp[2]) && isMathSign(splitExp[1]);
    }

    private boolean isNumber(String s) {
        if (Double.isNaN(Double.parseDouble(s.trim()))) {
            System.out.println("Ошибка: " + s + " не является числом");
            return false;
        }
        return true;
    }

    private boolean isMathSign(String s) {
        if (s.trim().matches("[+\\-*/^%]")) {
            return true;
        }
        System.out.println("Ошибка: " + s + " не является символом арифметической операции, " +
                "поддерживаемый программой");
        return false;
    }

    public double calculate(double a, double b, char sign) {
        return switch (sign) {
            case '-' -> a - b;
            case '+' -> a + b;
            case '*' -> a * b;
            case '/' -> {
                if (isZero(b)) {
                    yield Double.NaN;
                }
                yield a / b;
            }
            case '^' -> Math.pow(a, b);
            case '%' -> {
                if (isZero(b)) {
                    yield Double.NaN;
                }
                yield Math.IEEEremainder(a, b);
            }
            default -> Double.NaN;
        };
    }

    private boolean isZero(double b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return b == 0;
    }
}