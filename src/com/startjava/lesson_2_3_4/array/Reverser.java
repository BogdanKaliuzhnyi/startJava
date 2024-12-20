package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] emptyArray = new int[0];
        int[] reversed = reverse(emptyArray);
        printResult(emptyArray, reversed);

        int[] nullArray = null;
        reversed = reverse(nullArray);
        printResult(nullArray, reversed);

        int[] shortArray = {6, 8, 9, 1};
        reverse(shortArray);
        printResult(shortArray, reversed);

        int[] longArray = {13, 8, 5, 3, 2, 1, 1};
        reversed = reverse(longArray);
        printResult(longArray, reversed);
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

    private static boolean hasElements(int[] original) {
        if (original == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return false;
        }
        return true;
    }

    private static void printResult(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }
}
