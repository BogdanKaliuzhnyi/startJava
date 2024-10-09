package lesson_1;

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
            System.out.println("Число " + a + " больше числа " + b);
        } else if (a < b) {
            System.out.println("Число " + b + " больше числа " + a);
        } else {
            System.out.println("Числа " + a + " и " + b + " равны");
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
        boolean isHundredsEqual = c / 100 == d / 100;
        boolean isTensEqual = c % 100 / 10 == d % 100 / 10;
        boolean isOnesEqual = c % 10 == d % 10;
        if (isHundredsEqual || isTensEqual || isOnesEqual) {
            System.out.println("Исходные числа: " + c + " и " + d);
            System.out.print("Одинаковые цифры в числах: ");
            String radix = "";
            if (isHundredsEqual) {
                System.out.print(c / 100 + " ");
                radix = "3 ";
            }
            if (isTensEqual) {
                System.out.print((c % 100 / 10) + " ");
                radix = radix.concat("2 ");
            }
            if (isOnesEqual) {
                System.out.print((c % 10) + " ");
                radix = radix.concat("1 ");
            }
            System.out.println("\nНомера разрядов одинаковых цифр: " + radix);
        } else {
            System.out.println("В числах нет одинаковых цифр в одних и тех же разрядах");
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        System.out.print("'" + symbol + "' - ");
        if (Character.isUpperCase(symbol)) {
            System.out.println("большая буква");
        } else if (Character.isLowerCase(symbol)) {
            System.out.println("маленькая буква");
        } else if (Character.isDigit(symbol)) {
            System.out.println("цифра");
        } else {
            System.out.println("ни буква и ни цифра");
        }

        System.out.println("\n6. Подсчет начисленных банком %:");
        double deposit = 321123.59;
        double interestRate = 0.1;
        if (deposit < 100000) {
            interestRate = 0.05;
        } else if (deposit < 300000) {
            interestRate = 0.07;
        }
        System.out.println("Сумма вклада: " + deposit);
        System.out.printf("Сумма начисленных процентов по вкладу: %.2f\n", deposit * interestRate);
        System.out.printf("Итоговая сумма, с %%: %.2f\n", deposit + deposit * interestRate);

        System.out.println("\n7. Определение оценки по предметам:");
        double historyPercent = 0.59;
        int historyGrade = 5;
        if (historyPercent <= 0.6) {
            historyGrade = 2;
        } else if (historyPercent < 0.73) {
            historyGrade = 3;
        } else if (historyPercent < 0.91) {
            historyGrade = 4;
        }
        double csPercent = 0.92;
        int csGrade = 5;
        if (csPercent <= 0.6) {
            csGrade = 2;
        } else if (csPercent < 0.73) {
            csGrade = 3;
        } else if (csPercent < 0.91) {
            csGrade = 4;
        }
        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + csGrade);
        System.out.printf("Средний балл оценок по предметам: %.2f\n", (historyGrade + csGrade) / 2d);
        System.out.printf("Средний %% по предметам: %.2f\n", (historyPercent + csPercent) / 2 * 100);

        System.out.println("\n8. Расчет годовой прибыли:");
        double monthlySales = 16025.233;
        double monthlyRentRate = 5123.018;
        double productCost = 9001.729;
        double annualProfit = 12 * (monthlySales - monthlyRentRate - productCost);
        System.out.print("Прибыль за год: ");
        if (annualProfit > 0) {
            System.out.print("+");
        }
        System.out.printf("%.2f руб.\n", annualProfit);

        System.out.println("\n9. Расчет годовой прибыл (бонус задача)");
        var monthlySalesBd = new BigDecimal("16025.233");
        var monthlyRentBd = new BigDecimal("5123.018");
        var productCostBd = new BigDecimal("9001.729");
        var monthlyProfit = monthlySalesBd.subtract(monthlyRentBd).subtract(productCostBd);
        var annualProfitBd = monthlyProfit.multiply(BigDecimal.valueOf(12)).setScale(2, RoundingMode.HALF_UP);
        System.out.print("Прибыль за год: ");
        if (annualProfitBd.compareTo(BigDecimal.ZERO) > 0) {
            System.out.print("+");
        }
        System.out.println(annualProfitBd + " руб.\n");

        System.out.println("\n10. Подсчет начисленных банком % (бонус задача):");
        var depositBd = new BigDecimal("321123.59");
        BigDecimal interestRateBd = new BigDecimal("0.1");
        if (depositBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            interestRateBd = new BigDecimal("0.05");
        } else if (depositBd.compareTo(BigDecimal.valueOf(300000)) < 0) {
            interestRateBd = new BigDecimal("0.07");
        }
        var interestAmount = depositBd.multiply(interestRateBd).setScale(2, RoundingMode.HALF_UP);
        var totalAmount = depositBd.add(interestAmount);
        System.out.println("Сумма вклада: " + depositBd);
        System.out.println("Сумма начисленного %: " + interestAmount);
        System.out.println("Итоговая сумма с %: " + totalAmount);
    }
}