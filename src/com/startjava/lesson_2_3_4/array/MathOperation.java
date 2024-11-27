package com.startjava.lesson_2_3_4.array;

public class MathOperation {
    public static void main(String[] args) {
        int[] empty = {};
        calculateFactorials(empty);
        int[] nullArray = null;
        calculateFactorials(nullArray);
        int[] threeNumbers = {8, 0, 9};
        calculateFactorials(threeNumbers);
        int[] fourNumbers = {-3, 1, 7, 13};
        calculateFactorials(fourNumbers);
        int[] twoNumbers = {-22, -0};
        calculateFactorials(twoNumbers);
    }

    private static void calculateFactorials(int[] array) {
        if (!checkValue(array)) {
            return;
        }
        for (int number : array) {
            printNumberFactorial(number);
        }
        System.out.print('\n');
    }

    private static boolean checkValue(int[] array) {
        if (array == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return false;
        } else if (array.length == 0) {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
            return false;
        }
        return true;
    }

    private static void printNumberFactorial(int... number) {
        int currentNumber = number[0];

        if (currentNumber < 0) {
            System.out.println("Ошибка: факториал " + currentNumber + "! не определен");
        } else if (currentNumber == 0) {
            System.out.println("0! = 1");
        } else {
            long result = 1;
            System.out.print(currentNumber + "! = ");
            for (int i = 1; i <= currentNumber; i++) {
                result *= i;
                System.out.print(i != currentNumber ? i + " * " : i + " = " + result + "\n");
            }
        }
    }
}