package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterStylePrinter {
    public static void main(String[] args) throws InterruptedException {
        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling";
        System.out.println((int)'\n');
        type(mergeText(splitText(text), findShortestLongestWordIndexes(splitText(text))));

        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n- Robert Martin";
        type(mergeText(splitText(text), findShortestLongestWordIndexes(splitText(text))));

        text = null;
        type(mergeText(splitText(text), findShortestLongestWordIndexes(splitText(text))));

        text = "";
        type(mergeText(splitText(text), findShortestLongestWordIndexes(splitText(text))));
    }

    private static String[] splitText(String text) {
        if (isEmpty(text)) {
            return null;
        }
        return text.split("[ \\t\\r]");
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
            int wordLen = separatedText[i].replaceAll("[ -/:-?]|( \\+ )", "").length();
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

        int[] indexes = new int[]{shortestIndex, longestIndex};
        Arrays.sort(indexes);
        return indexes;
    }

    private static StringBuilder mergeText(String[] separatedText, int[] indexes) {
        if (separatedText == null) {
            return null;
        }

        StringBuilder mergedText = new StringBuilder();
        for (int i = 0; i < separatedText.length; i++) {
            if (i >= indexes[0] && i <= indexes[1]) {
                mergedText.append(separatedText[i].toUpperCase());
            } else {
                mergedText.append(separatedText[i]);
            }
            mergedText.append(i == separatedText.length - 1 ? "" : " ");
        }
        return mergedText;
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