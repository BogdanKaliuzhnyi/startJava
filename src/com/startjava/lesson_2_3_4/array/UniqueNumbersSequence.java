package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersSequence {
    public static void main(String[] args) {
        int start = -30;
        int end = -10;
        int amount = 23;
        int[] uniqueNumbers;
        if (isValidParameters(start, end, amount)) {
            uniqueNumbers = generateSorted(start, end);
            printSequence(start, end, amount, uniqueNumbers);
        }

        start = 10;
        end = 50;
        amount = 30;
        if (isValidParameters(start, end, amount)) {
            uniqueNumbers = generateSorted(start, end);
            printSequence(start, end, amount, uniqueNumbers);
        }

        start = -34;
        end = -34;
        amount = 0;
        if (isValidParameters(start, end, amount)) {
            uniqueNumbers = generateSorted(start, end);
            printSequence(start, end, amount, uniqueNumbers);
        }

        start = -1;
        end = 2;
        amount = 3;
        if (isValidParameters(start, end, amount)) {
            uniqueNumbers = generateSorted(start, end);
            printSequence(start, end, amount, uniqueNumbers);
        }

        start = 5;
        end = -8;
        amount = 2;
        if (isValidParameters(start, end, amount)) {
            uniqueNumbers = generateSorted(start, end);
            printSequence(start, end, amount, uniqueNumbers);
        }
    }

    private static boolean isValidParameters(int start, int end, int amount) {
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
        return Math.abs((end - start) / 4 * 3);
    }

    private static int[] generateSorted(int start, int end) {
        int[] randomNumbers = new int[calculateArrayLength(start, end)];
        Arrays.fill(randomNumbers, -999999999);
        Random random = new Random();
        int uniqueNum;

        for (int i = 0; i < randomNumbers.length; i++) {
            do {
                uniqueNum = random.nextInt(end + 1 - start) + start;
            } while (!isUniqueNumber(randomNumbers, i, uniqueNum));
            randomNumbers[i] = uniqueNum;
        }
        Arrays.sort(randomNumbers);
        return randomNumbers;
    }

    private static boolean isUniqueNumber(int[] array, int index, int number) {
        for (int i = 0; i <= index; i++) {
            if (array[i] == number) {
                return false;
            }
        }
        return true;
    }

    private static void printSequence(int start, int end, int amount, int[] array) {
        System.out.printf("\nВ заданной границе [%d, %d] создан массив из уникальных чисел:\n", start, end);
        System.out.println(Arrays.toString(array));
        StringBuilder sequence = new StringBuilder();
        System.out.printf("Первые %d чисел из полученного массива:\n", amount);

        for (int i = 0; i < amount; i++) {
            sequence.append(array[i]).append(i == amount - 1 ? "." : ", ");
        }
        System.out.println(sequence);
    }
}