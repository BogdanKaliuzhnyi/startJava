package com.startjava.lesson_2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Arrays.asciiTriangleCreator('0', '9', true);
        Arrays.asciiTriangleCreator('/', '!', false);
        Arrays.asciiTriangleCreator('A', 'J', false);

        Arrays.factorial(new int[0]);
        Arrays.factorial(null);
        Arrays.factorial(8, 0, 9);
        Arrays.factorial(-3, 1, 7, 13);
        Arrays.factorial(-22, -0);

        Arrays.reverser(new int[0]);
        Arrays.reverser(null);
        Arrays.reverser(new int[]{6, 8, 9, 1});
        Arrays.reverser(new int[]{13, 8, 5, 3, 2, 1, 1});

        Arrays.typewriterStylePrinter("Java - это C++, из которого убрали все пистолеты, " +
                "ножи и дубинки.\n- James Gosling");
        Arrays.typewriterStylePrinter("Чтобы написать чистый код, мы сначала пишем грязный код, " +
                "затем рефакторим его.\n- Robert Martin");
        Arrays.typewriterStylePrinter(null);
        Arrays.typewriterStylePrinter("");

        Arrays.uniqueNumberFiller(-30, -10, 23);
        Arrays.uniqueNumberFiller(10, 50, 10);
        Arrays.uniqueNumberFiller(-34, -34, 0);
        Arrays.uniqueNumberFiller(-1, -2, 3);
        Arrays.uniqueNumberFiller(5, -8, 2);

        Arrays.zeroer(15, new int[]{-1, 15, 0, 14});
    }
}