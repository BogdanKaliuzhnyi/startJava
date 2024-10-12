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
        for (int i = --max; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр:");
        int number = 1234;
        int sum = 0;
        System.out.print("Исходное число в обратном порядке, поразрядно: ");
        while (number != 0) {
            int remainder = number % 10;
            System.out.print(remainder + " ");
            number /= 10;
            sum += remainder;
        }
        System.out.println("\nСумма выделенных цифр: " + sum);

        System.out.println("\n4. Вывод чисел в несколько строк:");
        int start = 1;
        int end = 24;
        int lineLength = 5;
        int count = 0;
        System.out.println("Нечетные числа в полуинтервале [" + start + ", " + end + ") " +
                "в строку, длиной в " + lineLength + " чисел:");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.printf("%3d", i);
                count++;
            }
            if (count == lineLength) {
                System.out.println();
                count = 0;
            }
        }
        if (count > 0) {
            for (int i = count; i < lineLength; i++) {
                System.out.printf("%3d", 0);
            }
        }

        System.out.println("\n\n5. Проверка количества двоек числа на четность/нечетность:");
        int c = 3242592;
        int countTwos = 0;
        System.out.print("В " + c + " ");
        while (c / 10 != 0) {
            if (c % 10 == 2) {
                countTwos++;
            }
            c /= 10;
        }
        System.out.println(countTwos % 2 == 0 ? "четное" : "нечетное" + " (" + countTwos + ") количество двоек");

        System.out.println("\n6. Вывод геометрических фигур:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
        int line = 0;
        int row = 5;
        while (row > 0) {
            System.out.print('#');
            line++;
            if (line == row) {
                System.out.println();
                row--;
                line = 0;
            }
        }
        System.out.println();
        int line1 = 0;
        int row1 = 1;
        do {
            if (line1 < row1) {
                System.out.print('$');
                line1++;
            } else {
                System.out.println();
                row1++;
                line1 = 0;
            }
        } while (row1 <= 2);
        do {
            if (line1 < row1) {
                System.out.print('$');
                line1++;
            } else {
                System.out.println();
                row1--;
                line1 = 0;
            }
        } while (row1 > 0);

        System.out.println("\n7. Вывод ASCII-символов:");
        System.out.printf("%s %11s %13s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i < 48; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d %10c \t\t   %-15s%n", i, i, Character.getName(i));
            }
        }
        for (int i = 97; i < 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d %10c \t\t   %-15s%n", i, i, Character.getName(i));
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом:");
        int magicNumber = 1234321;
        int reversed = 0;
        System.out.print("Число " + magicNumber);
        while (magicNumber > reversed) {
            int i = magicNumber % 10;
            reversed = reversed * 10 + i;
            magicNumber /= 10;
        }
        boolean isPalindromic = magicNumber == reversed || magicNumber == reversed / 10;
        System.out.println(" - " + (isPalindromic ? "палиндром" : "не палиндром"));

        System.out.println("\n9. Проверка, является ли число счастливым:");
        int luckyNumber = 123321;
        System.out.print("Число " + luckyNumber + " - ");
        int firstThreeNumber = 0;
        int lastThreeNumber = 0;
        for (int i = 0; i < 6; i++) {
            int reminder = luckyNumber % 10;
            if (i < 3) {
                lastThreeNumber += reminder;
            } else {
                firstThreeNumber += reminder;
            }
            luckyNumber /= 10;
        }
        System.out.println(firstThreeNumber == lastThreeNumber ? "счастливое" : "не счастливое" + " число");
        System.out.println("Сумма первых трех чисел " + firstThreeNumber);
        System.out.println("Сумма последних трех чисел " + lastThreeNumber);

        System.out.println("\n10. Вывод таблицы умножения Пифагора:");
        System.out.print("   |");
        for (int i = 0; i < 10; i++) {
            if (i > 1) {
                System.out.printf("%2d |", i);
            } else if (i == 1) {
                System.out.print("---|");
            }
            for (int j = 2; j < 10; j++) {
                if (i > 1) {
                    System.out.printf("%4d", i * j);
                } else if (i < 1) {
                    System.out.printf("%4d", j);
                } else if (i == 1) {
                    System.out.print("----");
                }
            }
            System.out.println();
        }
    }
}
