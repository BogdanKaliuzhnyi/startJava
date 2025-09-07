package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private static final int EXPR_LENGTH = 3;
    private static final int SIGN_LENGTH = 1;

    private Calculator() {
    }

    public static double calculate(String expr) {
        String[] splitExpr = expr.split(" ");
        validateExprLength(splitExpr);

        int a = parseNumber(splitExpr[0]);
        int b = parseNumber(splitExpr[2]);
        char sign = splitExpr[1].charAt(0);
        return switch (sign) {
            case '-' -> a - b;
            case '+' -> a + b;
            case '*' -> a * b;
            case '^' -> Math.pow(a, b);
            case '/', '%' -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Ошибка: деление на 0");
                }
                yield sign == '/' ? ((double) a / b) : Math.IEEEremainder(a, b);
            }
            default -> throw new UnexpectedInputException("Ошибка: " + sign + " не является символом " +
                    "арифметической операции, поддерживаемый программой");
        };
    }

    private static void validateExprLength(String[] splitExp) {
        if (splitExp.length != EXPR_LENGTH) {
            throw new UnexpectedInputException("\nОшибка: введенные данные не соответствуют установленному " +
                    "формату: \"Число_Пробел_ЗнакМатематическойОперации_Пробел_Число\"");
        }

        if (splitExp[1].length() != SIGN_LENGTH) {
            throw new UnexpectedInputException("\nОшибка: операция " + splitExp[1] + " не поддерживается");
        }
    }

    private static int parseNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка: введен неподдерживаемый операнд" + s);
        }
    }
}