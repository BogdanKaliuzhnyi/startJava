package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    Calculator() {
        System.out.print("Введите выражение из трех аргументов, например, 2 ^ 10: ");
    }

    private final int EXPRESSION_LENGTH = 3;

    public double calculate(String expression) {
        String[] splitExpression = expression.split(" ");
        if (!isValidExpression(splitExpression)) {
            return Double.NaN;
        }

        int a = Integer.parseInt(splitExpression[0]);
        int b = Integer.parseInt(splitExpression[2]);
        char sign = splitExpression[1].charAt(0);
        return switch (sign) {
            case '-' -> a - b;
            case '+' -> a + b;
            case '*' -> a * b;
            case '/', '%' -> {
                if (isZero(b)) {
                    yield Double.NaN;
                }
                yield sign == '/' ? ((double) a / (double) b) : Math.IEEEremainder(a, b);
            }
            case '^' -> Math.pow(a, b);
            default -> Double.NaN;
        };
    }

    private boolean isValidExpression(String[] splitExp) {
        if (splitExp.length != EXPRESSION_LENGTH) {
            System.out.println("Ошибка: введенные данные не соответствуют установленному формату " +
                    "\"Число_Пробел_ЗнакМатематическойОперации_Пробел_Число\"");
            return false;
        }
        return isMathSign(splitExp[1]);
    }

    private boolean isMathSign(String s) {
        if (s.trim().matches("[+\\-*/^%]")) {
            return true;
        }
        System.out.println("Ошибка: " + s + " не является символом арифметической операции, " +
                "поддерживаемый программой");
        return false;
    }

    private boolean isZero(double b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return b == 0;
    }
}