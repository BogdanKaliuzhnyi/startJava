package com.startjava.lesson_2_3_4.array;

public class AsciiTriangleCreator {
    public static void main(String[] args) {
        System.out.println(createSorted('0', '9', true));
        System.out.println(createSorted('/', '!', false));
        System.out.println(createSorted('A', 'J', false));
    }

    private static StringBuilder createSorted(char start, char end, boolean isAscendOrder) {
        if (!isValidBorders(start, end)) {
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

    private static boolean isValidBorders(int start, int end) {
        if (start < 0 || end < 0 || start > 255 || end > 255) {
            System.out.println("Ошибка: указанные границы выходят за пределы допустимых значений [0:255]");
            return false;
        }
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > правой (" + end + ")");
            return false;
        }
        return true;
    }
}
