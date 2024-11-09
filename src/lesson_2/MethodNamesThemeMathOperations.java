package lesson_2;

public class MethodNamesThemeMathOperations {
    public static void main(String[] args) {
        MethodNamesThemeMathOperations math = new MethodNamesThemeMathOperations();
        math.getGameOperationMethods(new MethodNamesThemeGameOperations());
        math.getTextOperationMethods(new MethodNamesThemeTextOperations());
        math.getSystemOperationMethods(new MethodNamesThemeSystemOperations());
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName() + " -> ";
    }

    public void calculateAverageGrade() {
        System.out.println(getMethodName() + "рассчитать среднюю оценку в школе");
    }

    public void convertCelsiusToFahrenheit() {
        System.out.println(getMethodName() + "преобразовать температуру из Цельсия в Фаренгейт");
    }

    public void evaluateMathematicalExpression() {
        System.out.println(getMethodName() + "выведение математического выражения");
    }

    public boolean hasUniqueDigits() {
        System.out.println(getMethodName() + "последовательность содержит уникальную цифру?");
        return false;
    }

    public boolean hasEqualDigits() {
        System.out.println(getMethodName() + "есть равные цифры?");
        return false;
    }

    public void getGameOperationMethods(MethodNamesThemeGameOperations m) {
        m.determineWinner();
        m.hasRemainingAttempts();
        m.isEvenNumber();
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