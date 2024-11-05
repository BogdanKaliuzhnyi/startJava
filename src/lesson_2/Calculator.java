package lesson_2;

public class Calculator {
    public void calculate(int a, char sign, int b) {
        double result;

        switch (sign) {
            case '-':
                result = a - b;
                break;
            case '+':
                result = a + b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (!isZero(b)) {
                    result = (double) a / b;
                    break;
                }
                return;
            case '^':
                result = pow(a, b);
                break;
            case '%':
                if (!isZero(b)) {
                    result = a % b;
                    break;
                }
                return;
            default:
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
                return;
        }
        printResult(result);
    }

    private boolean isZero(int b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return b == 0;
    }

    private double pow(int a, int b) {
        double result = 1;
        for (int i = Math.abs(b); i > 0; i--) {
            result *= a;
        }
        return b > 0 ? result : 1 / result;
    }

    private void printResult(double result) {
        if (result % 1 == 0) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }
}
