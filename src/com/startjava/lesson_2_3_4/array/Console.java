package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {
        throw new AssertionError();
    }

    static void printAmountNumbersPerLineError(int amount) {
        System.out.printf("Ошибка: количество чисел в строке не может быть меньше 1 (%d)\n\n", amount);
    }

    static void printArrayEmptyError(boolean isNull) {
        if (isNull) {
            System.out.println("Ошибка: массив не может быть null.\n");
        } else {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
        }
    }

    static void printArrayLengthError(int length, int amount) {
        System.out.printf("\nОшибка: количество чисел %d в строке не может быть больше длины массива (%d)\n\n",
                amount, length);
    }

    static void printArrayLengthError(int length) {
        System.out.printf("Ошибка: длина массива должна быть больше 0 (%d)\n", length);
    }

    static void printBordersError() {
        System.out.println("Ошибка: указанные границы выходят за пределы допустимых значений [0:255]\n");
    }

    static void printBordersOrderError(int startBorder, int endBorder) {
        System.out.println("Ошибка: левая граница (" + startBorder + ") > правой (" + endBorder + ")\n");
    }

    static void printIncorrectIndex(int index) {
        System.out.println("Ошибка: некорректный индекс " + index + "\n");
    }

    static void printFactorialError(int wrongNumber) {
        System.out.println("Ошибка: факториал " + wrongNumber + "! не определен.\n");
    }

    static void printFactorialExpr(StringBuilder expression) {
        System.out.println(expression + "\n");
    }

    static void printTriangle(StringBuilder triangle) {
        System.out.println(triangle);
    }

    static void printReversedNumbers(int[] original, int[] reversed) {
        System.out.println("   До реверса: " + Arrays.toString(original));
        System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
    }

    static void type(StringBuilder modifiedText) throws InterruptedException {
        for (char c : modifiedText.toString().toCharArray()) {
            System.out.print(c);
            Thread.sleep(2);
        }
        System.out.println();
    }

    static void printUniqueNumbersArray(StringBuilder array, int numbersPerLine) {
        System.out.printf("Печать массива с отображение %d чисел в строке:\n", numbersPerLine);
        System.out.println(array);
    }

    static void printUniqueNumbersArray(StringBuilder array, int start, int end) {
        System.out.printf("В заданной границе [%d, %d] создан массив из уникальных чисел:\n", start, end);
        System.out.println(array);
    }

    static void printZeroerArrays(StringBuilder originalMessage) {
        System.out.println(originalMessage);
    }
}
