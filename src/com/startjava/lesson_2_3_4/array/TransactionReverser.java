package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        reverse(new int[]{});
        reverse(null);
        reverse(new int[]{5});
        reverse(new int[]{6, 8, 9, 1});
        reverse(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void reverse(int[] original) {
        if (!hasElements(original) || original.length == 0) {
            return;
        }

        int length = original.length;
        int[] reversed = new int[length];
        for (int i : original) {
            reversed[--length] = i;
        }
        printResult(original, reversed);
    }

    private static boolean hasElements(int[] original) {
        if (original == null) {
            System.out.println("Массив null (ошибка данных).\n");
            return false;
        } else if (original.length == 0) {
            System.out.println("Массив пустой (нет транзакций).\n");
            return false;
        }
        return true;
    }

    private static void printResult(int[] original, int[] reversed) {
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed) + "\n");
    }
}
