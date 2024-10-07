package lesson1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера:");
        byte cpuCoreAmount = 8;
        System.out.println("Количество ядер процессора: " + cpuCoreAmount);
        short ramAmount = 16;
        System.out.println("Объем оперативной памяти, gb: " + ramAmount);
        int batteryCapacity = 41050;
        System.out.println("Емкость аккумулятора, mWh: " + batteryCapacity);
        long hddMemoryCapacity = 1024L;
        System.out.println("Объем жесткого диска, gb: " + hddMemoryCapacity);
        float displayDiagonal = 14.5f;
        System.out.println("Диагональ дисплея, дюймов: " + displayDiagonal);
        double laptopWeight = 3.7;
        System.out.println("Вес ноутбука, кг: " + laptopWeight);
        boolean hasLiquidCooling = false;
        System.out.println("Наличие жидкостной системы охлаждения: " + hasLiquidCooling);
        char cpuManufacturerShort = 'I';
        System.out.println("Первая буква производителя процессора: '" + cpuManufacturerShort + "'");

        System.out.println("\n2. Расчет стоимости товара со скидкой:");
        float penPrice = 105.5f;
        float bookPrice = 235.83f;
        float discount = 0.11f;
        float totalPrice = penPrice + bookPrice;
        System.out.printf("Стоимость товара без скидки: %.2f\n", totalPrice);
        System.out.printf("Сумма скидки: %.2f\n", totalPrice * discount);
        System.out.printf("Стоимость товара со скидкой: %.2f\n",totalPrice * (1 - discount));

        System.out.println("\n3. Вывод слова JAVA:");
        System.out.println("    J    a  v     v  a    ");
        System.out.println("    J   a a  v   v  a a   ");
        System.out.println(" J  J  aaaaa  V V  aaaaa  ");
        System.out.println("  JJ  a     a  V  a     a ");

        System.out.println("\n4. Вывод min и max значений целых числовых типов:");
        byte byteNumber = 127;
        System.out.println("Максимальное значение byte: " + byteNumber);
        System.out.println("Значение после инкремента byte: " + ++byteNumber);
        System.out.println("Значение после декремента byte: " + --byteNumber);
        short shortNumber = 32767;
        System.out.println("Максимальное значение short: " + shortNumber);
        System.out.println("Значение после инкремента short: " + ++shortNumber);
        System.out.println("Значение после декремента short: " + --shortNumber);
        int intNumber = 2147483647;
        System.out.println("Максимальное значение int: " + intNumber);
        System.out.println("Значение после инкремента int: " + ++intNumber);
        System.out.println("Значение после декремента int: " + --intNumber);
        long longNumber = 9223372036854775807L;
        System.out.println("Максимальное значение long: " + longNumber);
        System.out.println("Значение после инкремента long: " + ++longNumber);
        System.out.println("Значение после декремента long: " + --longNumber);

        System.out.println("\n5. Перестановка значений переменных:");
        int a = 2;
        int b = 5;
        System.out.println("Перестановка значений переменных с помощью третьей переменной:");
        System.out.println("Исходные значения переменных: " + a +
                " и " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Новые значения переменных: " + a + " и " + b);
        System.out.println("Перестановка значений переменных с помощью арифметических операций:");
        a = b + a;
        b = a - b;
        a = a - b;
        System.out.println("Новые значения переменных: " + a + " и " + b);
        System.out.println("Перестановка значений переменных с помощью побитовых операций:");
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Новые значения переменных: " + a + " и " + b);

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
        System.out.println("" + slash + underscore + underscore + underscore + underscore +
                 slash + backSlash + underscore + underscore + backSlash);

        System.out.println("\n8. Манипуляции с сотнями, десятками и единицами числа:");
        int number = 123;
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int units = number % 10;
        System.out.println("Число " + number + " содержит:");
        System.out.println("\tсотен - " + hundreds);
        System.out.println("\tдесятков - " + tens);
        System.out.println("\tединиц - " + units);
        System.out.println("Сумма разрядов = " + (hundreds + tens + units));
        System.out.println("Произведение разрядов = " + (hundreds * tens * units));

        System.out.println("\n9. Перевод секунд в часы, минуты и секунды:");
        int seconds = 86399;
        System.out.println(seconds + " секунд это " +
                (seconds / 3600) + ":" + ((seconds % 3600) / 60) + ":" + seconds % 60);

        System.out.println("\n10. Расчет стоимости товара со скидкой (бонус):");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.83");
        var discountBd = new BigDecimal("0.11");
        var basePrise = penPriceBd.add(bookPriceBd);
        var discountAmount = basePrise.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        var discountPrice = basePrise.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Стоимость товаров без скидки: " + basePrise.toPlainString());
        System.out.println("Сумма скидки: " + discountAmount.toPlainString());
        System.out.println("Стоимость товаров со скидкой: " + discountPrice);
    }
}
