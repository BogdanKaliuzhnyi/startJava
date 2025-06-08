package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[] original = new int[]{};
        printResult(original, reverse(original));

        original = null;
        printResult(original, reverse(original));

        original = new int[]{5};
        printResult(original, reverse(original));

        original = new int[]{6, 8, 9, 1};
        printResult(original, reverse(original));

        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        printResult(original, reverse(original));
    }

    private static boolean hasElements(int[] original) {
        if (original == null) {
            System.out.println("Массив null (ошибка данных).\n");
            return false;
        }

        if (original.length == 0) {
            System.out.println("Массив пустой (нет транзакций).\n");
            return false;
        }

        return true;
    }

    private static void printResult(int[] original, int[] reversed) {
        if (reversed == null) {
            return;
        }

        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed) + "\n");
    }

    private static int[] reverse(int[] original) {
        if (!hasElements(original)) {
            return null;
        }

        int length = original.length;
        int[] reversed = new int[length];
        for (int i : original) {
            reversed[--length] = i;
        }

        return reversed;
    }
}