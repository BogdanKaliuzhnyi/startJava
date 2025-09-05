package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPRESSION_LENGTH = 3;

    private Calculator() {
    }

    public static double calculate(String expression) {
        String[] splitExpression = expression.trim().split("[\\s]+");
        validateExpLength(splitExpression);

        int a = getNumber(splitExpression[0]);
        int b = getNumber(splitExpression[2]);
        char sign = getSign(splitExpression[1]);
        return switch (sign) {
            case '-' -> a - b;
            case '+' -> a + b;
            case '*' -> a * b;
            case '^' -> Math.pow(a, b);
            case '/', '%' -> {
                if (b == 0) {
                    throw new CalculatorException("Ошибка: деление на 0");
                }
                yield sign == '/' ? ((double) a / (double) b) : Math.IEEEremainder(a, b);
            }
            default -> throw new CalculatorException("Ошибка: " + sign + " дал неожиданный результат");
        };
    }

    private static void validateExpLength(String[] splitExp) {
        if (splitExp.length != EXPRESSION_LENGTH) {
            throw new CalculatorException("\nОшибка: введенные данные не соответствуют установленному формату " +
                    "\"Число_Пробел_ЗнакМатематическойОперации_Пробел_Число\"");
        }
    }

    private static int getNumber(String s) {
        if (s.matches("(\\d\\.\\d)|(\\d,\\d)")) {
            throw new CalculatorException("Ошибка: вещественные числа не поддерживаются программой");
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new CalculatorException("Ошибка: " + s + " не является числом");
        }
    }

    private static char getSign(String s) {
        if (s.matches("[+\\-*/^%]")) {
            return s.charAt(0);
        }
        throw new CalculatorException("Ошибка: " + s + " не является символом арифметической операции, " +
                "поддерживаемый программой");
    }

    static class CalculatorException extends RuntimeException {
        private CalculatorException(String message) {
            super(message);
        }
    }
}