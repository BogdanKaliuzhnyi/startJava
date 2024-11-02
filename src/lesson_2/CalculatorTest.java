package lesson_2;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isCalculating;

        do {
            System.out.print("Введите первое число: ");
            int a = sc.nextInt();
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            char sign = sc.next().charAt(0);
            System.out.print("Введите второе число: ");
            int b = sc.nextInt();
            Calculator.calculate(a, sign, b);

            String repeat;
            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]:");
                repeat = sc.next();
            } while (!repeat.equalsIgnoreCase("yes") && !repeat.equalsIgnoreCase("no"));
            isCalculating = repeat.equalsIgnoreCase("yes");

        } while (isCalculating);
    }
}