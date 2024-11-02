package lesson_2;

public class Calculator {
    public static void calculate(int a, char sign, int b) {
        switch (sign) {
            case '-':
                System.out.println(a - b);
                break;
            case '+':
                System.out.println(a + b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                if (b != 0) {
                    double result = (double) a / b;
                    if (result % 1 == 0) {
                        System.out.println((int) result);
                    } else {
                        System.out.println(result);
                    }
                } else {
                    System.out.println("Ошибка: деление на ноль запрещено");
                }
                break;
            case '^':
                int result = 1;
                if (b < 0) {
                    for (int i = b; i < 0; i++) {
                        result *= a;
                    }
                    System.out.println((double) 1 / result);
                } else {
                    for (int i = 0; i < b; i++) {
                        result *= a;
                    }
                    System.out.println(result);
                }
                break;
            case '%':
                System.out.println(a % b);
                break;
            default:
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
                break;
        }
    }
}
