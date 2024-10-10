package lesson_1;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел:");
        int a = -10;
        int b = 21;
        int sumEven = 0;
        int sumOdd = 0;
        System.out.print("В отрезке [" + a + ", " + b + "] сумма четных чисел = ");
        do {
            if (a % 2 == 0) {
                sumEven += a;
            } else {
                sumOdd += a;
            }
            a++;
        } while (a <= b);
        System.out.println(sumEven + ", а нечетных = " + sumOdd);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания:");
        int x = 10;
        int y = 5;
        int z = -1;
        int min = x < y ? x < z ? x : z : y < z ? y : z;
        int max = x > y ? x > z ? x : z : y > z ? y : z;
        System.out.println("Среди чисел " + x + ", " + y + ", " + z + ", min: " + min + ", max: " + max);
        System.out.println("Числа в диапазоне (" + min + ", " + max + ") в порядке убывания: ");
        for (
                int i = --max;
                i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр:");
        int number = 1234;
        int sum = 0;
        System.out.print("Исходное числе в обратном порядке, поразрядно: ");
        while (number != 0) {
            int remainder = number % 10;
            System.out.print(remainder + " ");
            number /= 10;
            sum += remainder;
        }
        System.out.println("\nСумма выделенных цифр: " + sum);

        System.out.println("\n4.Вывод чисел в несколько строк:");
        int c = 1;
        int d = 24;
        int lineLength = 5;
        int scope = (d - c - 1);
        int count = 0;
        for (int i = c; i <= scope / lineLength * lineLength; i++) {
            if (i % 2 != 0) {
                System.out.printf("%-3d", 1);
            } else {
                System.out.printf("%-3d", 0);
            }
            count++;
            if (count == lineLength) {
                System.out.println();
                count = 0;
            }
        }
        int zeroLastLine = scope % lineLength;
        for (int i = 1; i <= lineLength; i++) {
            if (zeroLastLine != 0) {
                System.out.printf("%-3d", 0);
                zeroLastLine--;
            } else if (i % 2 != 0) {
                System.out.printf("%-3d", 1);
            } else {
                System.out.printf("%-3d", 0);
            }
        }
    }
}
