package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static void asciiTriangleCreator(char start, char end, boolean isAscendOrder) {
        if (start < 0 || end < 0 || start > 255 || end > 255) {
            Console.printBordersError();
            return;
        }
        if (start > end) {
            Console.printBordersOrderError(start, end);
            return;
        }

        int currentSymbol = isAscendOrder ? start : end;
        StringBuilder triangle = new StringBuilder();
        int spaces = end - start;
        int repeats = 0;
        while (currentSymbol >= start && currentSymbol <= end) {
            triangle.append(" ".repeat(spaces));
            triangle.append(String.valueOf((char) currentSymbol).repeat(1 + repeats++ * 2));
            triangle.append("\n");
            spaces--;
            currentSymbol += isAscendOrder ? 1 : -1;
        }
        Console.printTriangle(triangle);
    }

    public static void factorial(int... numbers) {
        if (isNull(numbers)) {
            Console.printArrayEmptyError(true);
            return;
        }
        int length = numbers.length;
        if (length == 0) {
            Console.printArrayEmptyError(false);
            return;
        }

        long[] factorials = new long[length];
        for (int i = 0; i < length; i++) {
            if (factorials[i] >= 0) {
                factorials[i] = 1;
                for (int j = 2; j <= numbers[i]; j++) {
                    factorials[i] *= j;
                }
            }
        }
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0) {
                Console.printFactorialError(numbers[i]);
                expression.setLength(0);
                continue;
            }
            if (numbers[i] > 1) {
                expression.append(numbers[i]).append("! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    expression.append(j != numbers[i] ? j + " * " : j + " = ");
                }
                Console.printFactorialExpr(expression.append(factorials[i]));
                expression.setLength(0);
                continue;
            }
            Console.printFactorialExpr(expression.append(numbers[i]).append("! = 1"));
            expression.setLength(0);
        }
    }

    public static void reverser(int[] original) {
        if (isNull(original)) {
            Console.printArrayEmptyError(true);
            return;
        }
        int length = original.length;
        int[] reversed = new int[length];
        for (int i : original) {
            reversed[--length] = i;
        }
        Console.printReversedNumbers(original, reversed);
    }

    public static void typewriterStylePrinter(String originalText) throws InterruptedException {
        if (originalText == null || originalText.isBlank()) {
            return;
        }

        String[] separatedText = originalText.split("[ \\t\\r]");
        int shortestLen = 10;
        int shortestIndex = 0;
        int longestLen = 0;
        int longestIndex = 0;

        for (int i = 0; i < separatedText.length; i++) {
            int wordLen = separatedText[i].replaceAll("\\p{P}", "").length();
            if (wordLen == 0) {
                continue;
            }
            shortestLen = Math.min(shortestLen, wordLen);
            if (shortestLen == wordLen) {
                shortestIndex = i;
            }
            longestLen = Math.max(longestLen, wordLen);
            if (longestLen == wordLen) {
                longestIndex = i;
            }
        }

        StringBuilder mergedText = new StringBuilder();
        for (int i = 0; i < separatedText.length; i++) {
            if (i >= Math.min(shortestIndex, longestIndex) && i <= Math.max(shortestIndex, longestIndex)) {
                mergedText.append(separatedText[i].toUpperCase());
            } else {
                mergedText.append(separatedText[i]);
            }
            mergedText.append(i == separatedText.length - 1 ? "" : " ");
        }
        Console.type(mergedText);
    }

    public static void uniqueNumberFiller(int start, int end, int amount) {
        if (start > end) {
            Console.printBordersOrderError(start, end);
            return;
        }
        if (amount < 1) {
            Console.printAmountNumbersPerLineError(amount);
            return;
        }
        int length = (int) Math.abs((end - start) * 0.75);
        if (length < 1) {
            Console.printArrayLengthError(length);
            return;
        }
        if (length < amount) {
            Console.printArrayLengthError(length, amount);
            return;
        }

        int[] uniqueNumbers = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            boolean isUniqueNumber = true;
            while (isUniqueNumber) {
                int uniqueNumber = random.nextInt(start, end + 1);
                for (int j = 0; j <= i; j++) {
                    isUniqueNumber = uniqueNumbers[j] == uniqueNumber;
                }
                uniqueNumbers[i] = uniqueNumber;
            }
        }

        java.util.Arrays.sort(uniqueNumbers);
        StringBuilder originalSequence = new StringBuilder();
        StringBuilder changedSequence = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < length; i++) {
            originalSequence.append(uniqueNumbers[i]).append(i == length - 1 ? "" : " ");
            changedSequence.append(uniqueNumbers[i]).append(i == length - 1 ? "" : " ");
            counter++;
            if (counter == amount) {
                changedSequence.append("\n");
                counter = 0;
            }
        }
        Console.printUniqueNumbersArray(originalSequence, start, end);
        originalSequence.setLength(0);
        Console.printUniqueNumbersArray(changedSequence, amount);
        changedSequence.setLength(0);
    }

    public static void zeroer(int length, int[] indexes) {
        for (int index : indexes) {
            if (index >= 0 && index < length) {
                double[] originalArray = new double[length];
                for (int i = 0; i < length; i++) {
                    originalArray[i] = Math.random();
                }

                double[] zeroedArray = java.util.Arrays.copyOf(originalArray, length);
                StringBuilder originalMessage = new StringBuilder();
                StringBuilder zeroedMessage = new StringBuilder();
                int amount = 0;
                for (int i = 0; i < length; i++) {
                    if (zeroedArray[i] > zeroedArray[index]) {
                        zeroedArray[i] = 0.0;
                        amount++;
                    }
                }
                originalMessage.append("  Исходный массив:\n[");
                zeroedMessage.append("\nИзмененный массив:\n[");
                for (int i = 0; i < length; i++) {
                    originalMessage.append(String.format("%.3f", originalArray[i]));
                    originalMessage.append(i != length - 1 ? " " : "]");
                    zeroedMessage.append(String.format("%.3f", zeroedArray[i]));
                    zeroedMessage.append(i != length - 1 ? " " : "]");
                    if (i != 0 && i % 7 == 0) {
                        zeroedMessage.append("\n");
                    }
                }
                zeroedMessage.append("\nЗначение из ячейки по индексу ");
                zeroedMessage.append(String.format("%d: %.3f", index, originalArray[index]));
                zeroedMessage.append(String.format("\nКоличество обнуленных ячеек: %d\n", amount));

                Console.printZeroerArrays(originalMessage);
                Console.printZeroerArrays(zeroedMessage);
            } else {
                Console.printIncorrectIndex(index);
            }
        }
    }

    private static boolean isNull(int[] array) {
        return array == null;
    }
}