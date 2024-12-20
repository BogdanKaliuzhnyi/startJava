package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class Console {
    private Console() {
        throw new AssertionError();
    }

    static void printInputError(String errorText) {
        System.out.println("Ошибка: " + errorText + "\n");
    }

    static void printArrayEmptyError(boolean isNull) {
        if (isNull) {
            System.out.println("Ошибка: массив не может быть null.\n");
        } else {
            System.out.println("Ошибка: в указанном массиве отсутствуют числа.\n");
        }
    }

    static void printFactorialExpr(StringBuilder expression) {
        if (!isObjectNull(expression)) {
            System.out.println(expression + "\n");
        }
    }

    static void printTriangle(StringBuilder triangle) {
        if (!isObjectNull(triangle)) {
            System.out.println(triangle);
        }
    }

    static void printReversedNumbers(int[] original, int[] reversed) {
        if (!isObjectNull(original) || !isObjectNull(reversed)) {
            System.out.println("   До реверса: " + Arrays.toString(original));
            System.out.println("После реверса: " + Arrays.toString(reversed) + "\n");
        }
    }

    static void type(StringBuilder modifiedText) throws InterruptedException {
        if (isObjectNull(modifiedText)) {
            System.out.println();
            return;
        }
        for (char c : modifiedText.toString().toCharArray()) {
            System.out.print(c);
            Thread.sleep(200);
        }
        System.out.println();
    }

    static void printUniqueNumbersArray(StringBuilder array) {
        if (isObjectNull(array)) {
            return;
        }
        System.out.println(array);
    }

    static void printZeroerArrays(StringBuilder originalMessage) {
        if (!isObjectNull(originalMessage)) {
            System.out.println(originalMessage);
        }
    }

    static boolean isObjectNull(Object link) {
        return link == null;
    }
}
