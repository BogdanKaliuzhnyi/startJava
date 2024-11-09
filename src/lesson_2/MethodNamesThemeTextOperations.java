package lesson_2;

public class MethodNamesThemeTextOperations {
    public static void main(String[] args) {
        MethodNamesThemeTextOperations math = new MethodNamesThemeTextOperations();
        math.getGameOperationMethods(new MethodNamesThemeGameOperations());
        math.getMathOperationMethods(new MethodNamesThemeMathOperations());
        math.getSystemOperationMethods(new MethodNamesThemeSystemOperations());
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName() + " -> ";
    }

    public void findLongestWord() {
        System.out.println(getMethodName() + "поиск самого длинного слова в предложении");
    }

    public void countUniqueWords() {
        System.out.println(getMethodName() + "подсчет количество уникальных слов");
    }

    public void printErrorMessage() {
        System.out.println(getMethodName() + "вывести сообщение об ошибке");
    }

    public void findBook() {
        System.out.println(getMethodName() + "поиск книги");
    }

    public boolean isLiteral() {
        System.out.println(getMethodName() + "введена буква?");
        return true;
    }

    public boolean isEmptyStringOrSpaces() {
        System.out.println(getMethodName() + "введена пустая строка или пробелы?");
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
}
