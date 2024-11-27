package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class orderOperation {
    public static void main(String[] args) {
        int[] emptyArray = new int[0];
        makeReversed(emptyArray);

        int[] nullArray = null;
        makeReversed(nullArray);

        int[] shortArray = {6, 8, 9, 1};
        makeReversed(shortArray);

        int[] longArray = {13, 8, 5, 3, 2, 1, 1};
        makeReversed(longArray);
    }

    private static void makeReversed(int[] original) {
        if (!isNull(original)) {
            return;
        }
        printResult(original, reverseNumbers(original));
    }

    private static boolean isNull(int[] original) {
        if (original == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return false;
        }
        return true;
    }

    private static int[] reverseNumbers(int[] original) {
        int length = original.length;
        int[] reversed = new int[length];
        for (int i : original) {
            reversed[--length] = i;
        }
        return reversed;
    }

    private static void printResult(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }
}
