package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Zeroer {
    public static void main(String[] args) {
        int length = 15;
        double[] original = generateNewArray(length);
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            if (isValidIndex(length, index)) {
                double[] copy = Arrays.copyOf(original, original.length);
                int amount = fillZeros(copy, index);
                printResult(original, copy, index, amount);
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

    private static int fillZeros(double[] copy, int index) {
        int amount = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] > copy[index]) {
                copy[i] = 0.0;
                amount++;
            }
        }
        return amount;
    }

    private static void printResult(double[] original, double[] copy, int index, int amount) {
        System.out.print("  Исходный массив:\n[");
        printArray(original);
        System.out.print("\nИзмененный массив:\n[");
        printArray(copy);
        System.out.printf("\nЗначение из ячейки по индексу %d: %.3f", index, original[index]);
        System.out.println("\nКоличество обнуленных ячеек: " + amount + "\n");
    }

    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.3f" + (i != array.length - 1 ? ", " : "]"), array[i]);
            if (i != 0 && i % 7 == 0) {
                System.out.println();
            }
        }
    }
}