package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Locale;

public class Zeroer {
    public static void main(String[] args) {
        int length = 15;
        double[] original = generateNewArray(length);
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            if (isValidIndex(length, index)) {
                double[] copy = Arrays.copyOf(original, original.length);
                fillZeros(copy, index);
                printResult(original, copy, index);
            }
        }
    }

    private static double[] generateNewArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    private static boolean isValidIndex(int length, int index) {
        if (index < 0 || index > length - 1) {
            System.out.println("Ошибка: некорректный индекс " + index + "\n");
            return false;
        }
        return true;
    }

    private static void fillZeros(double[] copy, int index) {
        for (int i = index; i < copy.length; i++) {
            copy[i] = 0.0;
        }
    }

    private static void printResult(double[] original, double[] copy, int index) {
        System.out.print("  Исходный массив: [");
        printArray(original);
        System.out.print("\nИзмененный массив: [");
        printArray(copy);
        System.out.printf("\nЗначение из ячейки по индексу %d: %.3f", index, original[index]);
        System.out.println("\nКоличество обнуленных ячеек: " + (original.length - index) + "\n");
    }

    private static void printArray(double[] array) {
        Locale locale = Locale.US;
        for (int i = 0; i < array.length; i++) {
            System.out.printf(locale, "%.3f" + (i != array.length - 1 ? ", " : "]"), array[i]);
            if (i != 0 && i % 7 == 0) {
                System.out.println();
            }
        }
    }
}