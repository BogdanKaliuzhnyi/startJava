package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Reverser {
    public static void main(String[] args) {
        int[] reversed;
        int[] emptyArray = new int[0];
        reversed = reverseNumbers(emptyArray);
        printResult(emptyArray, reversed);

        int[] nullArray = null;
        reversed = reverseNumbers(nullArray);
        printResult(emptyArray, reversed);

        int[] shortArray = {6, 8, 9, 1};
        reverseNumbers(shortArray);
        printResult(emptyArray, reversed);

        int[] longArray = {13, 8, 5, 3, 2, 1, 1};
        reversed = reverseNumbers(longArray);
        printResult(emptyArray, reversed);
    }

    private static boolean isNull(int[] original) {
        if (original == null) {
            System.out.println("Ошибка: массив не может быть null.\n");
            return false;
        }
        return true;
    }

    private static int[] reverseNumbers(int[] original) {
        if (!isNull(original)) {
            return null;
        }
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
