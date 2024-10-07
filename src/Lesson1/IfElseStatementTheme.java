package lesson1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        boolean isSexMale = true;
        if (!isSexMale) {
            System.out.println("Женщина");
        } else {
            System.out.println("Мужчина");
        }

        int age = 17;
        if (age > 18) {
            System.out.println("Совершеннолетний");
        } else {
            System.out.println("Несовершеннолетний");
        }

        float height = 1.83f;
        if (height < 1.8) {
            System.out.println("Ты не очень высокий");
        } else {
            System.out.println("Ты высокий");
        }

        String name = "Ivan";
        char firstNameLetter = name.charAt(0);
        if (firstNameLetter == 'M') {
            System.out.println("Предполагаю, твоё имя Максим или Михаил");
        } else if (firstNameLetter == 'I') {
            System.out.println("Предполагаю твоё имя Иван или Игорь");
        } else {
            System.out.println("Дай мне еще подсказку");
        }

        System.out.println("\n2. Поиск большего числа:");
        int a = 4;
        int b = 312;
        if (a > b) {
            System.out.println("Первое число больше второго");
        } else if (a < b) {
            System.out.println("Второе число больше первого");
        } else {
            System.out.println("Числа равны");
        }

        System.out.println("\n3. Проверка числа");
        int x = 381;
        if (x != 0) {
            System.out.print(x + " является ");
            if (x > 0) {
                System.out.print("положительным ");
            } else {
                System.out.print("отрицательным ");
            }
            System.out.print("и ");
            if (x % 2 == 0) {
                System.out.println("четным");
            } else {
                System.out.println("нечетным");
            }
        } else {
            System.out.println("нулем");
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах:");
        int c = 123;
        int d = 223;
        if (c % 10 == d % 10 || c / 10 == d) {
            System.out.println("Исходные числа: " + c + " и " + d);
            System.out.print("Одинаковые цифры в числах: ");
            String radix = "";
            if (c / 100 == d / 100) {
                System.out.print(c / 100 + " ");
                radix = "3";
            }
            if (c % 100 / 10 == d % 100 / 10) {
                System.out.print(" " + (c % 100 / 10));
                radix = radix.concat(" 2");
            }
            if (c % 10 == d % 10) {
                System.out.print(" " + (c % 10));
                radix = radix.concat(" 1");
            }
            System.out.println("\nНомера разрядов одинаковых цифр: " + radix);
        } else {
            System.out.println("В числах нет одинаковых цифр в одних и тех же разрядах");
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        System.out.print("'" + symbol + "' - ");
        if (Character.isDigit(symbol)) {
            System.out.println("цифра");
        } else if (Character.isLetter(symbol)) {
            if (Character.isUpperCase(symbol)) {
                System.out.println("большая буква");
            } else {
                System.out.println("маленькая буква");
            }
        } else {
            System.out.println("ни буква и ни цифра");
        }

        System.out.println("\n6. Подсчет начисленных банком %:");
        double deposit = 321123.59;
        double rate;
        if (deposit < 100000) {
            rate = 0.05;
        } else if (deposit < 300000) {
            rate = 0.07;
        } else {
            rate = 0.1;
        }
        System.out.println("Сумма вклада: " + deposit);
        System.out.printf("Сумма начисленных процентов по вкладу: %.2f\n", deposit * rate);
        System.out.printf("Итоговая сумма, с %%: %.2f\n", deposit + deposit * rate);

        System.out.println("\n7. Определение оценки по предметам:");
        double historyKnowledge = 0.59;
        double csKnowledge = 0.92;
        int historyGrade;
        if (historyKnowledge <= 0.6) {
            historyGrade = 2;
        } else if (historyKnowledge < 0.73) {
            historyGrade = 3;
        } else if (historyKnowledge < 0.91) {
            historyGrade = 4;
        } else {
            historyGrade = 5;
        }
        int csGrade;
        if (csKnowledge <= 0.6) {
            csGrade = 2;
        } else if (csKnowledge < 0.73) {
            csGrade = 3;
        } else if (csKnowledge < 0.91) {
            csGrade = 4;
        } else {
            csGrade = 5;
        }
        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + csGrade);
        System.out.printf("Средний балл оценок по предметам: %.2f\n", (double) (historyGrade + csGrade) / 2);
        System.out.printf("Средний %% по предметам: %.2f\n", (historyKnowledge + csKnowledge) / 2 * 100);

        System.out.println("\n8. Расчет годовой прибыли:");
        double monthlyGoodsSells = 16025.233;
        double monthlyRentRate = 5123.018;
        double productCost = 9001.729;
        double annualProfit = 12 * (monthlyGoodsSells - monthlyRentRate - productCost);
        System.out.print("Прибыль за год: ");
        if (annualProfit > 0) {
            System.out.print("+");
        }
        System.out.printf("%.2f руб.\n", annualProfit);

        System.out.println("\n9. Расчет годовой прибыл (бонус задача)");
        var monthlySales = new BigDecimal("16025.233");
        var monthlyRent = new BigDecimal("5123.018");
        var monthlyCost = new BigDecimal("9001.729");
        var annualProfit1 = (monthlySales.subtract(monthlyRent.add(monthlyCost))).multiply(new BigDecimal("12"))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.print("Прибыль за год: ");
        if (annualProfit1.compareTo(BigDecimal.ZERO) > 0) {
            System.out.print("+");
        }
        System.out.println(annualProfit1 + " руб.\n");

        System.out.println("\n10. Подсчет начисленных банком % (бонус задача):");
        var depositAmount = new BigDecimal("321123.59");
        BigDecimal interestRate;
        if (depositAmount.compareTo(new BigDecimal("100000")) < 0) {
            interestRate = new BigDecimal("0.05");
        } else if (depositAmount.compareTo(new BigDecimal("300000")) < 0) {
            interestRate = new BigDecimal("0.07");
        } else {
            interestRate = new BigDecimal("0.1");
        }
        var interestAmount = depositAmount.multiply(interestRate).setScale(2, RoundingMode.HALF_UP);
        var totalAmount = depositAmount.add(interestAmount);
        System.out.println("Сумма вклада: " + depositAmount);
        System.out.println("Сумма начисленного %: " + interestAmount);
        System.out.println("Итоговая сумма с %: " + totalAmount);
    }
}