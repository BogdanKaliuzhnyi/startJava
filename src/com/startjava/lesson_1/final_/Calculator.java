package com.startjava.lesson_1.final_;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое натуральное число: ");
        int a = sc.nextInt();
        System.out.print("Введите оператор: ");
        char mathOperation = sc.next().charAt(0);
        System.out.print("Введите второе натуральное число: ");
        int b = sc.nextInt();
        if (a < 0 || b < 0) {
            System.out.println("Введенные числа не являются натуральными");
            return;
        }
        int result;
        if (mathOperation == '+') {
            result = a + b;
        } else if (mathOperation == '-') {
            result = a - b;
        } else if (mathOperation == '*') {
            result = a * b;
        } else if (mathOperation == '/') {
            result = a / b;
        } else if (mathOperation == '^') {
            result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
        } else if (mathOperation == '%') {
            result = a % b;
        } else {
            System.out.println("Операция " + mathOperation + " не поддерживается, попробуй другую");
            return;
        }
        System.out.println(a + " " + mathOperation + " " + b + " = " + result);
    }
}


