package lesson_1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое натуральное число: ");
        int a = sc.nextInt();
        System.out.print("Введите оператор: ");
        String mathOperation = sc.next();
        System.out.print("Введите второе натуральное число: ");
        int b = sc.nextInt();
        if (a < 0 || b < 0) {
            System.out.println("Введенные числа не являются натуральными");
        }
        int result;
        if (mathOperation.equals("+")) {
            result = a + b;
        } else if (mathOperation.equals("-")) {
            result = a - b;
        } else if (mathOperation.equals("*")) {
            result = a * b;
        } else if (mathOperation.equals("/")) {
            result = a / b;
        } else if (mathOperation.equals("^")) {
            result = a;
            for (int i = 1; i < b; i++) {
                result *= a;
            }
        } else if (mathOperation.equals("%")) {
            result = a % b;
        } else {
            System.out.println("Введен неправильный оператор");
            return;
        }
        System.out.println(a + " " + mathOperation + " " + b + " = " + result);
    }
}


