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
        if (!isValidParameters(start, end, amount)) {
            return null;
        }

        int[] randomUniqueNumbers = new int[calculateArrayLength(start, end)];
        Arrays.fill(randomUniqueNumbers, -999999999);
        Random random = new Random();
        int uniqueNum;

        for (int i = 0; i < randomUniqueNumbers.length; i++) {
            do {
                uniqueNum = random.nextInt(end + 1 - start) + start;
            } while (!isUniqueNumber(randomUniqueNumbers, i, uniqueNum));
            randomUniqueNumbers[i] = uniqueNum;
        }
        Arrays.sort(randomUniqueNumbers);
        return randomUniqueNumbers;
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
        return (int) Math.abs((end - start) * 0.75);
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
        if (array == null) {
            return;
        }

        System.out.printf("\nВ заданной границе [%d, %d] создан массив из уникальных чисел.\n", start, end);
        System.out.println(Arrays.toString(array));
        System.out.printf("Печать массива с отображение %d чисел в строке:\n", amount);
        StringBuilder sequence = new StringBuilder();

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            sequence.append(array[i]).append(i == array.length - 1 ? "." : ", ");
            counter++;
            if (counter == amount) {
                sequence.append("\n");
                counter = 0;
            }
        }
        System.out.println(sequence);
    }
}