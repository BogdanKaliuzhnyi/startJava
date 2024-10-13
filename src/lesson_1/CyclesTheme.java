package lesson_1;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел:");
        int startRange = -10;
        int endRange = 21;
        int sumEven = 0;
        int sumOdd = 0;
        System.out.print("В отрезке [" + startRange + ", " + endRange + "] сумма четных чисел = ");
        do {
            if (startRange % 2 == 0) {
                sumEven += startRange;
            } else {
                sumOdd += startRange;
            }
            startRange++;
        } while (startRange <= endRange);
        System.out.println(sumEven + ", а нечетных = " + sumOdd);

        System.out.println("\n2. Вывод чисел между min и max в порядке убывания:");
        int x = 10;
        int y = 5;
        int z = -1;
        int min;
        int max;
        if (x < y) {
            min = x < z ? x : z;
            max = y > z ? y : z;
        } else {
            min = y < z ? y : z;
            max = x > z ? x : z;
        }
        System.out.println("Среди чисел " + x + ", " + y + ", " + z + ", min: " + min + ", max: " + max);
        System.out.println("Числа в диапазоне (" + min + ", " + max + ") в порядке убывания: ");
        for (int i = --max; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр:");
        int number = 1234;
        int sum = 0;
        int reversed = 0;
        while (number > 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number /= 10;
            sum += remainder;
        }
        System.out.println("Исходное число в обратном порядке, поразрядно: " + reversed);
        System.out.println("Сумма выделенных цифр: " + sum);

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
        int numberWithTwos = 3242592;
        int countTwos = 0;
        System.out.print("В " + numberWithTwos + " ");
        while (numberWithTwos / 10 != 0) {
            if (numberWithTwos % 10 == 2) {
                countTwos++;
            }
            numberWithTwos /= 10;
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

        row = 5;
        line = 1;
        int currentLength = 1;
        do {
            do {
                System.out.print('$');
                currentLength++;
            } while (currentLength < line);
            currentLength = 0;
            row--;
            if (row >= 3) {
                line++;
            } else {
                line--;
            }
            System.out.println();
        } while (row > 0);

        System.out.println("\n7. Вывод ASCII-символов:");
        System.out.printf("%s %11s %13s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        for (int i = 33; i < 48; i++) {
            if (i % 2 != 0) {
                System.out.printf("%4d %10c \t   %-21s%n", i, i, Character.getName(i));
            }
        }
        for (int i = 97; i < 122; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d %10c \t   %-21s%n", i, i, Character.getName(i));
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом:");
        int magicNumber = 1234321;
        int reversedNumber = 0;
        System.out.print("Число " + magicNumber);
        while (magicNumber > reversedNumber) {
            int remainder = magicNumber % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            magicNumber /= 10;
        }
        boolean isPalindrome = magicNumber == reversedNumber || magicNumber == reversedNumber / 10;
        System.out.println(" - " + (isPalindrome ? "палиндром" : "не палиндром"));

        System.out.println("\n9. Проверка, является ли число счастливым:");
        int luckyNumber = 123321;
        System.out.print("Число " + luckyNumber + " - ");
        int leftHalf = 0;
        int rightHalf = 0;
        for (int i = 0; i < 6; i++) {
            int remainder = luckyNumber % 10;
            if (i < 3) {
                rightHalf += remainder;
            } else {
                leftHalf += remainder;
            }
            luckyNumber /= 10;
        }
        System.out.println(leftHalf == rightHalf ? "счастливое" : "не счастливое" + " число");
        System.out.println("Сумма первых трех чисел " + leftHalf);
        System.out.println("Сумма последних трех чисел " + rightHalf);

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
