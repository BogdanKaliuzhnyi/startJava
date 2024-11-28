package com.startjava.lesson_2_3_4.array;

public class Factorial {
    public static void main(String[] args) {
        int[] empty = {};
        calculate(empty);
        int[] nullArray = null;
        calculate(nullArray);
        int[] threeNumbers = {8, 0, 9};
        calculate(threeNumbers);
        int[] fourNumbers = {-3, 1, 7, 13};
        calculate(fourNumbers);
        int[] twoNumbers = {-22, -0};
        calculate(twoNumbers);
    }

    private static void calculate(int[] original) {
        if (!checkValue(original)) {
            return;
        }
        printResult(original, fillArray(original));
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
        long[] result = new long[original.length];
        for (int i = 0; i < original.length; i++) {
            result[i] = calculateFactorial(original[i]);
        }
        return result;
    }

    private static long calculateFactorial(int... number) {
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
        for (int i = 0; i < factorials.length; i++) {
            if (original[i] < 0) {
                System.out.println("Ошибка: факториал " + original[i] + "! не определен.");
                continue;
            }
            if (original[i] <= 1) {
                System.out.println(original[i] + "! = 1");
                continue;
            }
            System.out.print(original[i] + "! = ");
            for (int j = 1; j <= original[i]; j++) {
                System.out.print(j != original[i] ? j + " * " : j + " = ");
            }
            System.out.println(factorials[i]);
        }
        System.out.println();
    }
}