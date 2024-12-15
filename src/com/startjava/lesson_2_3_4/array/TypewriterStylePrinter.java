package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TypewriterStylePrinter {
    public static void main(String[] args) throws InterruptedException {
        String text = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling";
        type(text);

        text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.\n- Robert Martin";
        type(text);

        text = null;
        type(text);

        text = "";
        type(text);
    }

    private static void type(String origText) throws InterruptedException {
        if (isEmpty(origText)) {
            return;
        }

        String[] separated = splitText(origText);
        int[] indexesToUpperCase = findShortestLongestWordIndexes(separated);
        StringBuilder text = mergeText(separated, indexesToUpperCase);
        for (char c : text.toString().toCharArray()) {
            System.out.print(c);
            Thread.sleep(200);
        }
        System.out.println();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitText(String text) {
        return text.split("\\s");
    }

    private static int[] findShortestLongestWordIndexes(String[] separatedText) {
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

        int[] indexes = new int[]{shortestIndex, longestIndex};
        Arrays.sort(indexes);
        return indexes;
    }

    private static StringBuilder mergeText(String[] separatedText, int[] indexes) {
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
}