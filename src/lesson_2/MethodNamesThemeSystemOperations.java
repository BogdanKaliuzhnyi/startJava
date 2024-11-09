package lesson_2;

public class MethodNamesThemeSystemOperations {
    public static void main(String[] args) {
        MethodNamesThemeSystemOperations math = new MethodNamesThemeSystemOperations();
        math.getGameOperationMethods(new MethodNamesThemeGameOperations());
        math.getMathOperationMethods(new MethodNamesThemeMathOperations());
        math.getTextOperationMethods(new MethodNamesThemeTextOperations());
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName() + " -> ";
    }

    public void selectMenuItem() {
        System.out.println(getMethodName() + "выбрать пункт меню в приложении");
    }

    public void synchroniseCloudData() {
        System.out.println(getMethodName() + "синхронизировать данные с облаком");
    }

    public void restoreData() {
        System.out.println(getMethodName() + "восстановить данные");
    }

    public void interruptDownloading() {
        System.out.println(getMethodName() + "приостановить загрузку");
    }

    public void resetToFactorySettings() {
        System.out.println(getMethodName() + "сбросить настройки до заводских");
    }

    public void writeToFile() {
        System.out.println(getMethodName() + "записать данные в файл");
    }

    public boolean isRunning() {
        System.out.println(getMethodName() + "программа выполняется?");
        return true;
    }

    public boolean isDeletedFile() {
        System.out.println(getMethodName() + "файл удален?");
        return true;
    }

    public boolean isValidFilePath() {
        System.out.println(getMethodName() + "путь к файлу действителен?");
        return true;
    }

    public boolean isExistFile() {
        System.out.println(getMethodName() + "файл существует?");
        return false;
    }

    public void getGameOperationMethods(MethodNamesThemeGameOperations m) {
        m.determineWinner();
        m.hasRemainingAttempts();
        m.isEvenNumber();
    }

    private void getMathOperationMethods(MethodNamesThemeMathOperations m) {
        m.evaluateMathematicalExpression();
        m.calculateAverageGrade();
        m.convertCelsiusToFahrenheit();
        m.hasEqualDigits();
        m.hasUniqueDigits();
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


