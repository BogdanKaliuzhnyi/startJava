package com.startjava.lesson_2_3_4.array;

public class SpinnerAnimation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws InterruptedException {
        char[] loadingSymbols = new char[]{'-', '\\', '|', '/', '-'};
        int randomChance = (int) (Math.random() * 100) + 1;
        String access;
        if (randomChance > 70) {
            access = (ANSI_GREEN + "Access Granted!" + ANSI_RESET);
        } else {
            access= (ANSI_RED + "Access Denied!" + ANSI_RESET);
        }
        consoleWriter(loadingSymbols, access);
    }

    public static void consoleWriter(char[] loadingSymbols, String access) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (char symbol : loadingSymbols) {
                System.out.print("Hacking:  " + symbol);
                System.out.print('\r');
                Thread.sleep(200);
            }
        }
        System.out.println(access);
    }
}