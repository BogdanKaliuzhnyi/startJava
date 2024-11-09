package lesson_2;

public class MethodNamesThemeGameOperations {
    public static void main(String[] args) {
        MethodNamesThemeGameOperations math = new MethodNamesThemeGameOperations();
        math.getMathOperationMethods(new MethodNamesThemeMathOperations());
        math.getTextOperationMethods(new MethodNamesThemeTextOperations());
        math.getSystemOperationMethods(new MethodNamesThemeSystemOperations());
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName() + " -> ";
    }

    public void determineWinner() {
        System.out.println(getMethodName() + "определить победителя в игре");
    }

    public boolean hasRemainingAttempts() {
        System.out.println(getMethodName() + "остались еще попытки?");
        return true;
    }

    public boolean isEvenNumber() {
        System.out.println(getMethodName() + "выпало четное число?");
        return false;
    }

    public void getMathOperationMethods(MethodNamesThemeMathOperations m) {
        m.evaluateMathematicalExpression();
        m.calculateAverageGrade();
        m.convertCelsiusToFahrenheit();
        m.hasEqualDigits();
        m.hasUniqueDigits();
    }

    public void getSystemOperationMethods(MethodNamesThemeSystemOperations m) {
        m.interruptDownloading();
        m.resetToFactorySettings();
        m.restoreData();
        m.selectMenuItem();
        m.synchroniseCloudData();
        m.writeToFile();
        m.isDeletedFile();
        m.isExistFile();
        m.isRunning();
        m.isValidFilePath();
    }

    public void getTextOperationMethods(MethodNamesThemeTextOperations m) {
        m.countUniqueWords();
        m.findBook();
        m.findLongestWord();
        m.printErrorMessage();
        m.isEmptyStringOrSpaces();
        m.isLiteral();
    }
}