package com.startjava.lesson_2_3_4.array;

public class SpinnerAnimation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws InterruptedException {
        showAccess(isHacked());
    }

    public static boolean isHacked() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        for (int i = 0; i < 3; i++) {
            for (char symbol : spins) {
                System.out.print("Hacking: " + symbol);
                System.out.print('\r');
                Thread.sleep(200);
            }
        }
        return ((int) (Math.random() * 100) + 1) > 70;
    }

    public static void showAccess(boolean isHacked) {
        System.out.print("Hacking: ");
        if (!isHacked) {
            System.out.println(ANSI_RED + "Access Denied!" + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_GREEN + "Access Granted!" + ANSI_RESET);
    }
}