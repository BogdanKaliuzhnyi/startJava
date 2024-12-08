package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterStylePrinter {
    public static void main(String[] args) throws InterruptedException {
        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. - James Gosling";
        String[] separatedText = splitText(text);
        type(formatAndMergeText(separatedText, findShortestLongestWordIndexes(separatedText)));

        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его. - Robert Martin";
        separatedText = splitText(text);
        type(formatAndMergeText(separatedText, findShortestLongestWordIndexes(separatedText)));

        text = null;
        separatedText = splitText(text);
        type(formatAndMergeText(separatedText, findShortestLongestWordIndexes(separatedText)));

        text = "";
        separatedText = splitText(text);
        type(formatAndMergeText(separatedText, findShortestLongestWordIndexes(separatedText)));
    }

    private static String[] splitText(String text) {
        if (isEmpty(text)) {
            return null;
        }
        return text.split("\\s");
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static int[] findShortestLongestWordIndexes(String[] separatedText) {
        if (separatedText == null) {
            return null;
        }

        int shortestLen = 10;
        int shortestIndex = 0;
        int longestLen = 0;
        int longestIndex = 0;
        for (int i = 0; i < separatedText.length; i++) {
            int count = 0;
            for (int j = 0; j < separatedText[i].length(); j++) {
                if (!isPunctuationMark(separatedText[i].charAt(j))) {
                    count++;
                }
            }

            if (count == 0) {
                continue;
            }
            shortestLen = Math.min(shortestLen, count);
            if (shortestLen == count) {
                shortestIndex = i;
            }
            longestLen = Math.max(longestLen, count);
            if (longestLen == count) {
                longestIndex = i;
            }
        }

        int[] indexes = new int[]{shortestIndex, longestIndex};
        Arrays.sort(indexes);
        return indexes;
    }

    private static boolean isPunctuationMark(char symbol) {
        return symbol <= 34 || symbol >= 39 && symbol <= 42 || symbol == 63
                || symbol >= 44 && symbol <= 46 || symbol == 58 || symbol == 59;
    }

    private static StringBuilder formatAndMergeText(String[] separatedText, int[] indexes) {
        if (separatedText == null) {
            return null;
        }

        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < separatedText.length; i++) {
            if (i >= indexes[0] && i <= indexes[1]) {
                formattedText.append(separatedText[i].toUpperCase());
            } else {
                formattedText.append(separatedText[i]);
            }
            formattedText.append(i == separatedText.length - 1 ? "" : " ");
        }
        return formattedText;
    }

    private static void type(StringBuilder text) throws InterruptedException {
        if (text == null) {
            System.out.println("Пустая строка");
            return;
        }

        for (char c : text.toString().toCharArray()) {
            System.out.print(c);
            Thread.sleep(200);
        }
        System.out.println();
    }
}