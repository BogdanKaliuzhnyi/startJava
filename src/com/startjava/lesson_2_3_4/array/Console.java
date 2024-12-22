package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {
        throw new AssertionError();
    }

    static void printArrayEmptyError(boolean isNull) {
        if (isNull) {
            System.out.println("Ошибка: массив не может быть null.\n");
        } else {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
        }
    }

    static void printInputError(String errorText) {
        System.out.println("Ошибка: " + errorText + "\n");
    }

    static void printFactorialExpr(StringBuilder expression) {
        if (expression != null) {
            System.out.println(expression + "\n");
        }
    }

    static void printReversedNumbers(int[] original, int[] reversed) {
        if (original != null || reversed != null) {
            System.out.println("   До реверса: " + Arrays.toString(original));
            System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
        }
    }

    static void printReplacedValueInfo(double[][] array, int index) {
        if (array == null) {
            return;
        }
        StringBuilder originalMessage = new StringBuilder("  Исходный массив:\n[");
        StringBuilder zeroedMessage = new StringBuilder("\nИзмененный массив:\n[");
        int length = array[0].length;
        for (int i = 0; i < length; i++) {
            if (i != 0 && i % 8 == 0) {
                originalMessage.append("\n");
                zeroedMessage.append("\n");
            }
            originalMessage.append(String.format("%.3f", array[0][i]));
            originalMessage.append(i != length - 1 ? " " : "]");
            zeroedMessage.append(String.format("%.3f", array[1][i]));
            zeroedMessage.append(i != length - 1 ? " " : "]");
        }
        zeroedMessage.append("\nЗначение из ячейки по индексу ");
        zeroedMessage.append(String.format("%d: %.3f", index, array[0][index]));
        zeroedMessage.append(String.format("\nКоличество обнуленных ячеек: %.0f\n", array[2][0]));
        System.out.println(originalMessage.append(zeroedMessage));
    }

    static void printTriangle(StringBuilder triangle) {
        if (triangle != null) {
            System.out.println(triangle);
        }
    }

    static void type(StringBuilder text) throws InterruptedException {
        if (text == null) {
            System.out.println();
            return;
        }
        for (char c : text.toString().toCharArray()) {
            System.out.print(c);
            Thread.sleep(200);
        }
        System.out.println();
    }

    static void printUniqueNumbersArray(int[] uniqueNumbers, int start, int end, int amount) {
        if (uniqueNumbers == null) {
            return;
        }

        StringBuilder sequence = new StringBuilder("В заданной границе [" + start + ", " + end + "] ");
        sequence.append("создан массив из уникальных чисел:\n");
        StringBuilder supportSequence = new StringBuilder();
        int counter = 0;
        int length = uniqueNumbers.length;

        for (int i = 0; i < length; i++) {
            sequence.append(uniqueNumbers[i]).append(i == length - 1 ? "\n" : " ");
            supportSequence.append(uniqueNumbers[i]).append(i == length - 1 ? "" : " ");
            counter++;
            if (counter == amount) {
                supportSequence.append("\n");
                counter = 0;
            }
        }
        sequence.append("Печать массива с отображение ").append(amount).append(" чисел в строке:\n");
        System.out.println(sequence.append(supportSequence));
    }
}
