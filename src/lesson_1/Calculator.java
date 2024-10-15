package lesson_1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите первое натуральное число:");
            int firstOperand = sc.nextInt();
            System.out.println("Введите оператор:");
            String operationSign = sc.next();
            System.out.println("Введите второе натуральное число:");
            int secondOperand = sc.nextInt();
            if (firstOperand < 0 || secondOperand < 0) {
                System.out.println("Введенные числа не являются натуральными");
                break;
            }
            String result = firstOperand + " " + operationSign + " " + secondOperand + " = ";
            if (operationSign.equals("+")) {
                System.out.println(result + (firstOperand + secondOperand));
                break;
            } else if (operationSign.equals("-")) {
                System.out.println(result + (firstOperand - secondOperand));
                break;
            } else if (operationSign.equals("*")) {
                System.out.println(result + (firstOperand * secondOperand));
                break;
            } else if (operationSign.equals("/")) {
                System.out.println(result + (firstOperand / secondOperand));
                break;
            } else if (operationSign.equals("^")) {
                int temp = firstOperand;
                for (int i = 1; i < secondOperand; i++) {
                    firstOperand *= temp;
                }
                System.out.print(result + firstOperand);
                break;
            } else if (operationSign.equals("%")) {
                System.out.println(result + (firstOperand % secondOperand));
                break;
            } else {
                System.out.println("Введен неправильный оператор");
            }
        }
    }
}


