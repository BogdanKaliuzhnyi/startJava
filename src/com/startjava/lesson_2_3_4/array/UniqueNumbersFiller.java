package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        int start = -30;
        int end = -10;
        int amount = 23;
        int[] uniqueNumbers = generateSorted(start, end, amount);
        printSequence(start, end, amount, uniqueNumbers);

        start = 10;
        end = 50;
        amount = 10;
        uniqueNumbers = generateSorted(start, end, amount);
        printSequence(start, end, amount, uniqueNumbers);

        start = -34;
        end = -34;
        amount = 0;
        uniqueNumbers = generateSorted(start, end, amount);
        printSequence(start, end, amount, uniqueNumbers);

        start = -1;
        end = 2;
        amount = 3;
        uniqueNumbers = generateSorted(start, end, amount);
        printSequence(start, end, amount, uniqueNumbers);

        start = 5;
        end = -8;
        amount = 2;
        uniqueNumbers = generateSorted(start, end, amount);
        printSequence(start, end, amount, uniqueNumbers);
    }

    private static int[] generateSorted(int start, int end, int amount) {
        if (!isValidArgs(start, end, amount)) {
            return null;
        }

        int[] uniqueNumbers = new int[calculateArrayLength(start, end)];
        Random random = new Random();

        for (int i = 0; i < uniqueNumbers.length; i++) {
            int uniqueNumber;
            do {
                uniqueNumber = random.nextInt(start, end + 1);
            } while (!isUniqueNumber(uniqueNumber, i, uniqueNumbers));
            uniqueNumbers[i] = uniqueNumber;
        }
        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static boolean isValidArgs(int start, int end, int amount) {
        if (start > end) {
            System.out.printf("\nОшибка: левая граница (%d) > правой (%d)\n", start, end);
            return false;
        }
        if (amount < 1) {
            System.out.printf("\nОшибка: количество чисел в строке не может быть меньше 1 (%d)\n", amount);
            return false;
        }

        int length = calculateArrayLength(start, end);

        if (length < 1) {
            System.out.printf("\nОшибка: длина массива должна быть больше 0 (%d)\n", length);
            return false;
        }
        if (length < amount) {
            System.out.printf("\nОшибка: количество чисел %d в строке не может быть больше длины массива (%d)\n",
                    amount, length);
            return false;
        }
        return true;
    }

    private static int calculateArrayLength(int start, int end) {
        return (int) Math.abs((end - start) * 0.75);
    }

    private static boolean isUniqueNumber(int number, int index, int[] array) {
        for (int i = 0; i <= index; i++) {
            if (array[i] == number) {
                return false;
            }
        }
        return true;
    }

    private static void printSequence(int start, int end, int amount, int[] array) {
        if (array == null) {
            return;
        }

        System.out.printf("\nВ заданной границе [%d, %d] создан массив из уникальных чисел:\n", start, end);
        System.out.println(makeSequence(array.length, array));

        System.out.printf("\nПечать массива с отображение %d чисел в строке:\n", amount);
        System.out.println(makeSequence(amount, array));
    }

    private static StringBuilder makeSequence(int amount, int[] array) {
        StringBuilder sequence = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            sequence.append(array[i]).append(i == array.length - 1 ? "" : " ");
            counter++;
            if (counter == amount) {
                sequence.append("\n");
                counter = 0;
            }
        }
        return sequence;
    }
}