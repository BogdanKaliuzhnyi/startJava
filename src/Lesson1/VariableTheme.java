package lesson1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VariableTheme {
    public static void main(String[] args) {
        System.out.println("1. Displaying computer specification:");
        byte cpuCoreAmount = 8;
        System.out.println("Amount of CPU cores: " + cpuCoreAmount);
        short ram = 16;
        System.out.println("RAM, gb: " + ram);
        int batteryCapacity = 41050;
        System.out.println("Battery capacity, mWh: " + batteryCapacity);
        long hdd = 1024L;
        System.out.println("Hard disk drive value, gb: " + hdd);
        float displayDiagonal = 14.5f;
        System.out.println("Display diagonal, inch: " + displayDiagonal);
        double weight = 3.7;
        System.out.println("Laptop weight, kg: " + weight);
        boolean hasLiquidCooling = false;
        System.out.println("Liquid cooling system:" + hasLiquidCooling);
        char cpuManufacturerShort = 'I';
        System.out.println("CPU manufacturer short name: " + cpuManufacturerShort);

        System.out.println("\n2. Calculation of the cost of goods with a discount:");
        float penPrice = 105.5f;
        float bookPrice = 235.83f;
        float discount = 0.11f;
        System.out.printf("Final price without discount: %.2f\n", (penPrice + bookPrice));
        System.out.printf("Discount amount: %.2f\n", (penPrice + bookPrice) * discount);
        System.out.printf("Final price with discount: %.2f\n", (penPrice * (1 - discount) + bookPrice *
                (1 - discount)));

        System.out.println("\n3. Printing word JAVA:");
        System.out.println("    J    a  v     v  a    ");
        System.out.println("    J   a a  v   v  a a   ");
        System.out.println(" J  J  aaaaa  V V  aaaaa  ");
        System.out.println("  JJ  a     a  V  a     a ");

        System.out.println("\n4.Printing min and max values of integer numeric types:");
        byte byteNumber = 127;
        short shortNumber = 32767;
        int intNumber = 2147483647;
        long longNumber = 9223372036854775807L;
        System.out.println("Maximum value of byte variable:" + byteNumber);
        System.out.println("Incremented maximum value of byte variable:" + ++byteNumber);
        System.out.println("Decremented value of byte variable:" + --byteNumber);
        System.out.println("Maximum value of short variable:" + shortNumber);
        System.out.println("Incremented maximum value of short variable:" + ++shortNumber);
        System.out.println("Decremented value of short variable:" + --shortNumber);
        System.out.println("Maximum value of int variable:" + intNumber);
        System.out.println("Incremented maximum value of int variable:" + ++intNumber);
        System.out.println("Decremented value of int variable:" + --intNumber);
        System.out.println("Maximum value of long variable:" + longNumber);
        System.out.println("Incremented maximum value of long variable:" + ++longNumber);
        System.out.println("Decremented value of long variable:" + --longNumber);

        System.out.println("\n5. Rearranging variable values:");
        int firstNumber = 2;
        int secondNumber = 5;
        System.out.println("Rearranging variable values using a third variable:");
        System.out.println("Original value: the first number is: " + firstNumber +
                ", the second number is: " + secondNumber);
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
        System.out.println("After rearranging: the first number is: " + firstNumber +
                ", the second number is: " + secondNumber);
        System.out.println("Rearranging variable values using arithmetic operations:");
        firstNumber = secondNumber + firstNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
        System.out.println("After rearranging: the first number is: " + firstNumber +
                ", the second number is: " + secondNumber);
        System.out.println("Rearranging variable values using bitwise operations:");
        firstNumber = firstNumber ^ secondNumber;
        secondNumber = firstNumber ^ secondNumber;
        firstNumber = firstNumber ^ secondNumber;
        System.out.println("After rearranging: the first number is: " + firstNumber +
                ", the second number is: " + secondNumber);

        System.out.println("\n6. Printing symbols with codes:");
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

        System.out.println("\n7. Printing Duke's ASCII art:");
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

        System.out.println("\n8. Manipulation of hundreds, tens and units of numbers:");
        int origNumber = 123;
        System.out.println("Number " + origNumber + " includes:");
        System.out.println("\thundreds - " + origNumber / 100);
        System.out.println("\ttens - " + origNumber % 100 / 10);
        System.out.println("\tunits - " + origNumber % 100 % 10);
        System.out.println("Sum of digits = " + (origNumber / 100 + origNumber % 100 / 10 + origNumber % 100 % 10));
        System.out.println("Product of digits = " + (origNumber / 100 * (origNumber % 100 / 10) *
                (origNumber % 100 % 10)));

        System.out.println("\n9. Converting seconds to hours, minutes and seconds:");
        int seconds = 86399;
        System.out.println(seconds + " seconds is " + (seconds / 3600) + ":" + ((seconds % 3600) / 60) + ":" +
                seconds % 60);

        System.out.println("\n10. Calculation of the cost of goods with a discount (bonus):");
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.83");
        var discountBd = new BigDecimal("0.11");
        var totalFullPrice = penPriceBd.add(bookPriceBd);
        var discountAmount = totalFullPrice.multiply(discountBd).setScale(2, RoundingMode.HALF_UP);
        var totalPriceWithDiscount = totalFullPrice.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Final price without discount: " + totalFullPrice.toPlainString());
        System.out.println("Discount amount: " + discountAmount.toPlainString());
        System.out.println("Final price with discount: " + totalPriceWithDiscount);
    }
}
