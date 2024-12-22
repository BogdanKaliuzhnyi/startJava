package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder triangle = Arrays.createAsciiTriangle('0', '9', true);
        Console.printTriangle(triangle);
        triangle = Arrays.createAsciiTriangle('/', '!', false);
        Console.printTriangle(triangle);
        triangle = Arrays.createAsciiTriangle('A', 'J', false);
        Console.printTriangle(triangle);

        StringBuilder factorials = Arrays.calculateFactorials();
        Console.printFactorialExpr(factorials);
        factorials = Arrays.calculateFactorials(null);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.calculateFactorials(8, 0, 9);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.calculateFactorials(-3, 1, 7, 13);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.calculateFactorials(-22, -0);
        Console.printFactorialExpr(factorials);

        int[] original = new int[]{};
        int[] reversed = Arrays.reverseNumbers(original);
        Console.printReversedNumbers(original, reversed);
        original = null;
        reversed = Arrays.reverseNumbers(original);
        Console.printReversedNumbers(original, reversed);
        original = new int[]{6, 8, 9, 1};
        reversed = Arrays.reverseNumbers(original);
        Console.printReversedNumbers(original, reversed);
        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverseNumbers(original);
        Console.printReversedNumbers(original, reversed);

        StringBuilder sentence = Arrays.toUpperCaseShortestLongestWords("Java - это C++, из которого убрали" +
                " все пистолеты, ножи и дубинки.\n- James Gosling");
        Console.type(sentence);
        sentence = Arrays.toUpperCaseShortestLongestWords("Чтобы написать чистый код, мы сначала пишем " +
                "грязный код, затем рефакторим его.\n- Robert Martin");
        Console.type(sentence);
        sentence = Arrays.toUpperCaseShortestLongestWords("");
        Console.type(sentence);
        sentence = Arrays.toUpperCaseShortestLongestWords(null);
        Console.type(sentence);

        int[] uniqueNumbers = Arrays.generateUniqueNumbers(-30, -10, 23);
        Console.printUniqueNumbersArray(uniqueNumbers, -30, -10, 23);
        uniqueNumbers = Arrays.generateUniqueNumbers(10, 50, 10);
        Console.printUniqueNumbersArray(uniqueNumbers, 10, 50, 10);
        uniqueNumbers = Arrays.generateUniqueNumbers(-34, -34, 0);
        Console.printUniqueNumbersArray(uniqueNumbers, -34, -34, 0);
        uniqueNumbers = Arrays.generateUniqueNumbers(-1, -2, 3);
        Console.printUniqueNumbersArray(uniqueNumbers, -1, -2, 3);
        uniqueNumbers = Arrays.generateUniqueNumbers(5, -8, 2);
        Console.printUniqueNumbersArray(uniqueNumbers, 5, -8, 2);

        double[][] zeroer = Arrays.replaceGreaterThanAtIndex(-1);
        Console.printReplacedValueInfo(zeroer, -1);
        zeroer = Arrays.replaceGreaterThanAtIndex(15);
        Console.printReplacedValueInfo(zeroer, 15);
        zeroer = Arrays.replaceGreaterThanAtIndex(0);
        Console.printReplacedValueInfo(zeroer, 0);
        Console.printReplacedValueInfo(zeroer, 0);
        zeroer = Arrays.replaceGreaterThanAtIndex(14);
        Console.printReplacedValueInfo(zeroer, 14);
    }
}