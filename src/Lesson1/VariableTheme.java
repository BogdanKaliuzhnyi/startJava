package lesson1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера:");
        byte cpuCoreAmount = 8;
        System.out.println("Количество ядер процессора: " + cpuCoreAmount);
        short ram = 16;
        System.out.println("Объем оперативной памяти, gb: " + ram);
        int batteryCapacity = 41050;
        System.out.println("Емкость аккумулятора, mWh: " + batteryCapacity);
        long hdd = 1024L;
        System.out.println("Объем жесткого диска, gb: " + hdd);
        float displayDiagonal = 14.5f;
        System.out.println("Диагональ дисплея, дюймов: " + displayDiagonal);
        double weight = 3.7;
        System.out.println("Вес ноутбука, кг: " + weight);
        boolean hasLiquidCooling = false;
        System.out.println("Наличие жидкостной системы охлаждения: " + hasLiquidCooling);
        char cpuManufacturerShort = 'I';
        System.out.println("Первая буква производителя процессора: '" + cpuManufacturerShort + "'");

        System.out.println("\n2. Расчет стоимости товара со скидкой:");
        float penPrice = 105.5f;
        float bookPrice = 235.83f;
        float discount = 0.11f;
        System.out.printf("Стоимость товара без скидки: %.2f\n", (penPrice + bookPrice));
        System.out.printf("Сумма скидки: %.2f\n", (penPrice + bookPrice) * discount);
        System.out.printf("Стоимость товара со скидкой: %.2f\n", (penPrice * (1 - discount) + bookPrice *
                (1 - discount)));

        System.out.println("\n3. Вывод слова JAVA:");
        System.out.println("    J    a  v     v  a    ");
        System.out.println("    J   a a  v   v  a a   ");
        System.out.println(" J  J  aaaaa  V V  aaaaa  ");
        System.out.println("  JJ  a     a  V  a     a ");

        System.out.println("\n4. Вывод min и max значений целых числовых типов:");
        byte byteNumber = 127;
        short shortNumber = 32767;
        int intNumber = 2147483647;
        long longNumber = 9223372036854775807L;
        System.out.println("Максимальное значение byte: " + byteNumber);
        System.out.println("Значение после инкремента byte: " + ++byteNumber);
        System.out.println("Значение после декремента byte: " + --byteNumber);
        System.out.println("Максимальное значение short: " + shortNumber);
        System.out.println("Значение после инкремента short: " + ++shortNumber);
        System.out.println("Значение после декремента short: " + --shortNumber);
        System.out.println("Максимальное значение int: " + intNumber);
        System.out.println("Значение после инкремента int: " + ++intNumber);
        System.out.println("Значение после декремента int: " + --intNumber);
        System.out.println("Максимальное значение long: " + longNumber);
        System.out.println("Значение после инкремента long: " + ++longNumber);
        System.out.println("Значение после декремента long: " + --longNumber);

        System.out.println("\n5. Перестановка значений переменных:");
        int firstNumber = 2;
        int secondNumber = 5;
        System.out.println("Перестановка значений переменных с помощью третьей переменной:");
        System.out.println("Исходные значения переменных: " + firstNumber +
                " и " + secondNumber);
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
        System.out.println("Новые значения переменных: " + firstNumber + " и " + secondNumber);
        System.out.println("Перестановка значений переменных с помощью арифметических операций:");
        firstNumber = secondNumber + firstNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
        System.out.println("Новые значения переменных: " + firstNumber + " и " + secondNumber);
        System.out.println("Перестановка значений переменных с помощью побитовых операций:");
        firstNumber = firstNumber ^ secondNumber;
        secondNumber = firstNumber ^ secondNumber;
        firstNumber = firstNumber ^ secondNumber;
        System.out.println("Новые значения переменных: " + firstNumber + " и " + secondNumber);

        System.out.println("\n6. Вывод символов и их кодов:");
        char dollarSign = '$';
        char asterisk = '*';
        char atSign = '@';
        char pipe = '|';
        char tilde = '~';
        System.out.println((int) dollarSign + "\t" + dollarSign);
        System.out.println((int) asterisk + "\t" + asterisk);
        System.out.println((int) atSign + "\t" + atSign);
        System.out.println((int) pipe + "\t" + pipe);
        System.out.println((int) tilde + "\t" + tilde);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка:");
        char slash = '/';
        char backSlash = '\\';
        char underscore = '_';
        char openParen = '(';
        char closedParen = ')';
        System.out.println("    " + slash + backSlash);
        System.out.println("   " + slash + "  " + backSlash);
        System.out.println("  " + slash + underscore + openParen + " " + closedParen + backSlash);
        System.out.println(" " + slash + "      " + backSlash);
        System.out.println("" + slash + underscore + underscore + underscore + underscore + slash + backSlash +
                underscore + underscore + backSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа:");
        int number = 123;
        System.out.println("Число " + number + " содержит:");
        System.out.println("\tсотен - " + number / 100);
        System.out.println("\tдесятков - " + number % 100 / 10);
        System.out.println("\tединиц - " + number % 10);
        System.out.println("Сумма разрядов = " + (number / 100 + number % 100 / 10 + number % 10));
        System.out.println("Произведение разрядов = " + (number / 100 * (number % 100 / 10) * (number % 10)));

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды:");
        int seconds = 86399;
        System.out.println(seconds + " секунд это " + (seconds / 3600) + ":" + ((seconds % 3600) / 60) + ":" +
                seconds % 60);

        System.out.println("\n10. Расчет стоимости товара со скидкой (бонус):");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.83");
        var discountBd = new BigDecimal("0.11");
        var totalFullPrice = penPriceBd.add(bookPriceBd);
        var discountAmount = totalFullPrice.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        var totalPriceWithDiscount = totalFullPrice.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Стоимость товаров без скидки: " + totalFullPrice.toPlainString());
        System.out.println("Сумма скидки: " + discountAmount.toPlainString());
        System.out.println("Стоимость товаров со скидкой: " + totalPriceWithDiscount);
    }
}
