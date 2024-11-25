package com.startjava.lesson_2_3_4.array;

public class IncrementCalculation {
    public static void main(String[] args) {
        int[] empty = {};
        controlArrayValue(empty);
        int[] nullArray = null;
        controlArrayValue(nullArray);
        int[] threeNumbers = {8, 0, 9};
        controlArrayValue(threeNumbers);
        int[] fourNumbers = {-3, 1, 7, 13};
        controlArrayValue(fourNumbers);
        int[] twoNumbers = {-22, -0};
        controlArrayValue(twoNumbers);
    }

    private static void controlArrayValue(int[] array) {
        if (array == null) {
            System.out.println("Ошибка: Невозможно выполнить операцию с массивом без ссылки.\n");
            return;
        } else if (array.length == 0) {
            System.out.println("Ошибка: В указанном массиве отсутствуют числа для получения их инкремента.\n");
            return;
        }
        for (int number : array) {
            doIncrementCalculation(number);
        }
        System.out.print('\n');
    }

    private static void doIncrementCalculation(int... number) {
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