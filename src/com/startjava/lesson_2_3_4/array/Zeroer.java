package com.startjava.lesson_2_3_4.array;

import java.util.Locale;

public class Zeroer {
    public static void main(String[] args) {
        int length = 15;
        double[] original = generateNewArray(length);
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            if (!checkIndex(length, index)) {
                continue;
            }
            double[] copy = copyArray(original);
            fillZeros(copy, index);
            printResult(original, copy, index);
        }
    }

    private static double[] generateNewArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    private static boolean checkIndex(int length, int index) {
        if (index < 0 || index > length - 1) {
            System.out.println("Ошибка: некорректный индекс " + index + "\n");
            return false;
        }
        return true;
    }

    private static double[] copyArray(double[] original) {
        double[] arrayCopy = new double[original.length];
        for (int i = 0; i < original.length; i++) {
            arrayCopy[i] = original[i];
        }
        return arrayCopy;
    }

    private static void fillZeros(double[] copy, int index) {
        for (int i = index; i < copy.length; i++) {
            copy[i] = 0.0;
        }
    }

    private static void printResult(double[] original, double[] copy, int index) {
        Locale locale = Locale.US;
        System.out.print("  Исходный массив: [");
        for (int i = 0; i < original.length; i++) {
            System.out.printf(locale, "%.3f" + (i != original.length - 1 ? ", " : "]"), original[i]);
            if (i !=0 && i % 8 == 0) {
                System.out.println();
            }
        }
        System.out.print("\nИзмененный массив: [");
        for (int i = 0; i < copy.length; i++) {
            System.out.printf(locale, "%.3f" + (i != copy.length - 1 ? ", " : "]"), copy[i]);
            if (i !=0 && i % 8 == 0) {
                System.out.println();
            }
        }
        System.out.printf("\nЗначение из ячейки по индексу %d: %.3f", index, original[index]);
        System.out.println("\nКоличество обнуленных ячеек: " + (original.length - index) + "\n");
    }
}
