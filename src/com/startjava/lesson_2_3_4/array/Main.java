package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder triangle = Arrays.asciiTriangleCreator('0', '9', true);
        Console.printTriangle(triangle);
        triangle = Arrays.asciiTriangleCreator('/', '!', false);
        Console.printTriangle(triangle);
        triangle = Arrays.asciiTriangleCreator('A', 'J', false);
        Console.printTriangle(triangle);

        StringBuilder factorials = Arrays.factorial();
        Console.printFactorialExpr(factorials);
        factorials = Arrays.factorial(null);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.factorial(8, 0, 9);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.factorial(-3, 1, 7, 13);
        Console.printFactorialExpr(factorials);
        factorials = Arrays.factorial(-22, -0);
        Console.printFactorialExpr(factorials);

        int[] original = new int[]{};
        int[] reversed = Arrays.reverser(original);
        Console.printReversedNumbers(original, reversed);
        original = null;
        reversed = Arrays.reverser(original);
        Console.printReversedNumbers(original, reversed);
        original = new int[]{6, 8, 9, 1};
        reversed = Arrays.reverser(original);
        Console.printReversedNumbers(original, reversed);
        original = new int[]{13, 8, 5, 3, 2, 1, 1};
        reversed = Arrays.reverser(original);
        Console.printReversedNumbers(original, reversed);

        StringBuilder sentence = Arrays.typewriterStylePrinter("Java - это C++, из которого убрали все" +
                " пистолеты, ножи и дубинки.\n- James Gosling");
        Console.type(sentence);
        sentence = Arrays.typewriterStylePrinter("Чтобы написать чистый код, мы сначала пишем грязный код," +
                " затем рефакторим его.\n- Robert Martin");
        Console.type(sentence);
        sentence = Arrays.typewriterStylePrinter("");
        Console.type(sentence);
        sentence = Arrays.typewriterStylePrinter(null);
        Console.type(sentence);

        StringBuilder uniqueNumbers = Arrays.uniqueNumberFiller(-30, -10, 23);
        Console.printUniqueNumbersArray(uniqueNumbers);
        uniqueNumbers = Arrays.uniqueNumberFiller(10, 50, 10);
        Console.printUniqueNumbersArray(uniqueNumbers);
        uniqueNumbers = Arrays.uniqueNumberFiller(-34, -34, 0);
        Console.printUniqueNumbersArray(uniqueNumbers);
        uniqueNumbers = Arrays.uniqueNumberFiller(-1, -2, 3);
        Console.printUniqueNumbersArray(uniqueNumbers);
        uniqueNumbers = Arrays.uniqueNumberFiller(5, -8, 2);
        Console.printUniqueNumbersArray(uniqueNumbers);

        StringBuilder zeroer = Arrays.zeroer(-1);
        Console.printZeroerArrays(zeroer);
        zeroer = Arrays.zeroer(15);
        Console.printZeroerArrays(zeroer);
        zeroer = Arrays.zeroer(0);
        Console.printZeroerArrays(zeroer);
        Console.printZeroerArrays(zeroer);
        zeroer = Arrays.zeroer(14);
        Console.printZeroerArrays(zeroer);
    }
}