package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        long[] factorials;
        int[] empty = {};
        factorials = calculate(empty);
        printFactorialsExpression(empty, factorials);

        int[] nullArray = null;
        factorials = calculate(nullArray);
        printFactorialsExpression(nullArray, factorials);

        int[] threeNumbers = {8, 0, 9};
        factorials = calculate(threeNumbers);
        printFactorialsExpression(threeNumbers, factorials);

        int[] fourNumbers = {-3, 1, 7, 13};
        factorials = calculate(fourNumbers);
        printFactorialsExpression(fourNumbers, factorials);

        int[] twoNumbers = {-22, -0};
        factorials = calculate(twoNumbers);
        printFactorialsExpression(twoNumbers, factorials);
    }

    private static long[] calculate(int[] original) {
        if (isEmpty(original)) {
            return null;
        }
        long[] factorials = new long[original.length];
        for (int i = 0; i < original.length; i++) {
            factorials[i] = calcFactorial(original[i]);
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

    private static long calcFactorial(int... number) {
        int currentNumber = number[0];
        if (currentNumber <= 0) {
            return 0;
        }
        long factorial = 1;
        for (int i = 2; i <= currentNumber; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void printFactorialsExpression(int[] original, long[] factorials) {
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