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
                if (isLegalDivider(b)) {
                    result = (double) a / b;
                } else {
                    return;
                }
                break;
            case '^':
                result = raisingPower(a, b);
                break;
            case '%':
                if (isLegalDivider(b)) {
                    result = a % b;
                } else {
                    return;
                }
                break;
            default:
                System.out.println("Ошибка: операция '" + sign + "' не поддерживается.");
                return;
        }

        if (result % 1 == 0) {
            System.out.println((int) result);
        } else {
            System.out.println(result);
        }
    }

    boolean isLegalDivider(int b) {
        if (b == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
        }
        return b != 0;
    }

    double raisingPower(int a, int b) {
        double result = 1;
        for (int i = b > 0 ? b : b * -1; i > 0; i--) {
            result *= a;
        }
        if (b > 0) {
            return result;
        } else {
            return 1 / result;
        }
    }
}
