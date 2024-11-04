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
                if (!isSecondNumberZero(b)) {
                    result = (double) a / b;
                } else {
                    return;
                }
                break;
            case '^':
                result = pow(a, b);
                break;
            case '%':
                if (!isSecondNumberZero(b)) {
                    result = a % b;
                } else {
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
                return;
        }
        printResult(result);
    }

    private boolean isSecondNumberZero(int b) {
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
        if (b > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }

    private void printResult(double result) {
        if (result % 1 == 0) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }
}
