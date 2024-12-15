package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        long[] factorials = calculate(new int[0]);
        printFactorialsExpr(factorials, new int[0]);

        factorials = calculate(null);
        printFactorialsExpr(factorials, null);

        factorials = calculate(8, 0, 9);
        printFactorialsExpr(factorials, 8, 0, 9);

        factorials = calculate(-3, 1, 7, 13);
        printFactorialsExpr(factorials, -3, 1, 7, 13);

        factorials = calculate(-22, -0);
        printFactorialsExpr(factorials, -22, -0);
    }

    private static long[] calculate(int... numbers) {
        if (isEmpty(numbers)) {
            return null;
        }
        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            factorials[i] = calculateFactorial(numbers[i]);
        }
        return factorials;
    }

    private static boolean isEmpty(int[] array) {
        if (array == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return true;
        }
        if (array.length == 0) {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
            return true;
        }
        return false;
    }

    private static long calculateFactorial(int number) {
        if (number <= 0) {
            return 0;
        }
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void printFactorialsExpr(long[] factorials, int... original) {
        if (factorials == null) {
            return;
        }
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < factorials.length; i++) {
            if (original[i] < 0) {
                System.out.println(expression.append("Ошибка: факториал ")
                        .append(original[i]).append("! не определен."));
                expression.setLength(0);
                continue;
            }
            if (original[i] > 1) {
                expression.append(original[i]).append("! = ");
                for (int j = 1; j <= original[i]; j++) {
                    expression.append(j != original[i] ? j + " * " : j + " = ");
                }
                System.out.println(expression.append(factorials[i]));
                expression.setLength(0);
                continue;
            }

            System.out.println(expression.append(original[i]).append("! = 1"));
            expression.setLength(0);
        }
        System.out.println();
    }
}