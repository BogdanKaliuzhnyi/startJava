package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static StringBuilder asciiTriangleCreator(char start, char end, boolean isAscendOrder) {
        if (start < 0 || end < 0 || start > 255 || end > 255) {
            Console.printInputError("указанные границы выходят за пределы допустимых значений [0:255]");
            return null;
        }
        if (start > end) {
            Console.printInputError("левая граница (" + (int) start + ") > правой (" + (int) end + ")");
            return null;
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
        return triangle;
    }

    public static StringBuilder factorial(int... numbers) {
        if (isNull(numbers)) {
            Console.printArrayEmptyError(true);
            return null;
        }
        int length = numbers.length;
        if (length == 0) {
            Console.printArrayEmptyError(false);
            return null;
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
                Console.printInputError("факториал " + numbers[i] + "! не определен");
                continue;
            }
            if (numbers[i] > 1) {
                expression.append(numbers[i]).append("! = ");
                for (int j = 1; j <= numbers[i]; j++) {
                    expression.append(j != numbers[i] ? j + " * " : j + " = ");
                }
                expression.append(factorials[i]).append(i == length - 1 ? "" : "\n");
                continue;
            }
            expression.append(numbers[i]).append("! = 1\n");
        }
        return expression;
    }

    public static int[] reverser(int[] original) {
        if (isNull(original)) {
            Console.printArrayEmptyError(true);
            return null;
        }
        int length = original.length;
        int[] reversed = new int[length];
        for (int i : original) {
            reversed[--length] = i;
        }
        return reversed;
    }

    public static StringBuilder typewriterStylePrinter(String originalText) throws InterruptedException {
        if (isNull(originalText) || originalText.isBlank()) {
            return null;
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
        return mergedText;
    }

    public static StringBuilder uniqueNumberFiller(int start, int end, int amount) {
        if (start > end) {
            Console.printInputError("левая граница (" + start + ") > правой (" + end + ")");
            return null;
        }
        if (amount < 1) {
            Console.printInputError("количество чисел в строке не может быть меньше 1 (" + amount + ")");
            return null;
        }
        int length = (int) Math.abs((end - start) * 0.75);
        if (length < 1) {
            Console.printInputError("длина массива должна быть больше 0 (" + length + ")");
            return null;
        }
        if (length < amount) {
            Console.printInputError(" количество чисел " + amount + " в строке не может быть больше " +
                    "длины массива (" + length + ")");
            return null;
        }

        int[] uniqueNumbers = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            boolean isUniqueNumber = true;
            do {
                int uniqueNumber = random.nextInt(start, end + 1);
                for (int j = 0; j <= i; j++) {
                    isUniqueNumber = uniqueNumbers[j] != uniqueNumber;
                    if (!isUniqueNumber) {
                        break;
                    }
                }
                if (isUniqueNumber) {
                    uniqueNumbers[i] = uniqueNumber;
                }
            } while (!isUniqueNumber);
        }

        java.util.Arrays.sort(uniqueNumbers);
        StringBuilder originalSequence = new StringBuilder();
        StringBuilder changedSequence = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < length; i++) {
            originalSequence.append(uniqueNumbers[i]).append(i == length - 1 ? "\n" : " ");
            changedSequence.append(uniqueNumbers[i]).append(i == length - 1 ? "" : " ");
            counter++;
            if (counter == amount) {
                changedSequence.append("\n");
                counter = 0;
            }
        }
        StringBuilder resultSequence = new StringBuilder("В заданной границе [" + start + ", " + end + "] ");
        resultSequence.append("создан массив из уникальных чисел:\n").append(originalSequence);
        resultSequence.append("Печать массива с отображение ").append(amount).append(" чисел в строке:\n");
        return resultSequence.append(changedSequence);
    }

    public static StringBuilder zeroer(int index) {
        StringBuilder summaryMessage = new StringBuilder();
        int length = 15;
        if (index < 0 || index >= length) {
            Console.printInputError("некорректный индекс " + index);
            return null;
        }

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
            if (i != 0 && i % 8 == 0) {
                originalMessage.append("\n");
                zeroedMessage.append("\n");
            }
            originalMessage.append(String.format("%.3f", originalArray[i]));
            originalMessage.append(i != length - 1 ? " " : "]");
            zeroedMessage.append(String.format("%.3f", zeroedArray[i]));
            zeroedMessage.append(i != length - 1 ? " " : "]");
        }
        zeroedMessage.append("\nЗначение из ячейки по индексу ");
        zeroedMessage.append(String.format("%d: %.3f", index, originalArray[index]));
        zeroedMessage.append(String.format("\nКоличество обнуленных ячеек: %d\n", amount));
        summaryMessage.append(originalMessage).append(zeroedMessage);
        return summaryMessage;
}

private static boolean isNull(Object object) {
    return object == null;
}
}