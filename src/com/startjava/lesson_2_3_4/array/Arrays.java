package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class Arrays {
    private Arrays() {
        throw new AssertionError();
    }

    public static StringBuilder calculateFactorials(int... numbers) {
        if (numbers == null) {
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

    public static StringBuilder createAsciiTriangle(char start, char end, boolean isAscendOrder) {
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

    public static int[] generateUniqueNumbers(int start, int end, int amount) {
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
        return uniqueNumbers;
    }

    public static int replaceGreaterThanAtIndex(double[] original, double[] copy, int index) {
        int length = 15;
        if (index < 0 || index >= length) {
            Console.printInputError("некорректный индекс " + index);
            return -1;
        }

        for (int i = 0; i < length; i++) {
            original[i] = Math.random();
            copy[i] = original[i];
        }

        int amount = 0;
        for (int i = 0; i < length; i++) {
            if (copy[i] > original[index]) {
                copy[i] = 0.0;
                amount++;
            }
        }
        return amount;
    }

    public static int[] reverseNumbers(int[] original) {
        if (original == null) {
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

    public static StringBuilder toUpperCaseShortestLongestWords(String originalText) throws InterruptedException {
        if (originalText == null || originalText.isBlank()) {
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
}