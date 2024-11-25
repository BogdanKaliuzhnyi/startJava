package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ReverseArrayNumbers {
    public static void main(String[] args) {
        int[] emptyArray = new int[0];
        reverseArrayNumbers(emptyArray);

        int[] nullArray = null;
        reverseArrayNumbers(nullArray);

        int[] shortArray = {6, 8, 9, 1};
        reverseArrayNumbers(shortArray);

        int[] longArray = {13, 8, 5, 3, 2, 1, 1};
        reverseArrayNumbers(longArray);
    }

    private static void reverseArrayNumbers(int[] array) {
        if (array == null) {
            System.out.println("Ошибка, невозможно выполнить операцию с массивом без ссылки\n");
            return;
        }

        int length = array.length;
        int[] reversed = new int[length];
        for (int i : array) {
            reversed[--length] = i;
        }

        System.out.println("   До реверса: " + Arrays.toString(array));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }
}
