package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        long[] factorials;
        int[] empty = {};
        factorials = fillArray(empty);
        printResult(empty, factorials);

        int[] nullArray = null;
        factorials = fillArray(nullArray);
        printResult(nullArray, factorials);

        int[] threeNumbers = {8, 0, 9};
        factorials = fillArray(threeNumbers);
        printResult(threeNumbers, factorials);

        int[] fourNumbers = {-3, 1, 7, 13};
        factorials = fillArray(fourNumbers);
        printResult(fourNumbers, factorials);

        int[] twoNumbers = {-22, -0};
        factorials = fillArray(twoNumbers);
        printResult(twoNumbers, factorials);
    }

    private static boolean checkValue(int[] array) {
        if (array == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return false;
        }
        if (array.length == 0) {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
            return false;
        }
        return true;
    }

    private static long[] fillArray(int[] original) {
        if (!checkValue(original)) {
            return null;
        }
        long[] result = new long[original.length];
        for (int i = 0; i < original.length; i++) {
            result[i] = calculate(original[i]);
        }
        return result;
    }

    private static long calculate(int... number) {
        int currentNumber = number[0];
        if (currentNumber < 0) {
            return -1;
        }
        if (currentNumber == 0) {
            return 0;
        }
        long result = 1;
        for (int i = 2; i <= currentNumber; i++) {
            result *= i;
        }
        return result;
    }

    private static void printResult(int[] original, long[] factorials) {
        if (factorials == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < factorials.length; i++) {
            if (original[i] < 0) {
                System.out.println(sb.append("Ошибка: факториал ").append(original[i]).append("! не определен."));
                sb.setLength(0);
                continue;
            }
            if (original[i] <= 1) {
                System.out.println(sb.append(original[i]).append("! = 1"));
                sb.setLength(0);
                continue;
            }
            sb.append(original[i]).append("! = ");
            for (int j = 1; j <= original[i]; j++) {
                sb.append(j != original[i] ? j + " * " : j + " = ");
            }
            System.out.println(sb.append(factorials[i]));
            sb.setLength(0);
        }
        System.out.println();
    }
}