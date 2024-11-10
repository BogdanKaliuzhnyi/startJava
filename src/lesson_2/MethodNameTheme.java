package lesson_2;

public class MethodNameTheme {
    public static void main(String[] args) {
        MethodNameTheme m = new MethodNameTheme();
        m.getNonBooleanMethods(new NonBooleanMethods());
        m.getBooleanMethods(new BooleanMethods());
    }

    public void getNonBooleanMethods(NonBooleanMethods nbm) {
        nbm.findLongestWord();
        nbm.selectMenuItem();
        nbm.calculateAverageGrade();
        nbm.countUniqueWords();
        nbm.printErrorMessage();
        nbm.synchroniseCloudData();
        nbm.restoreData();
        nbm.pauseDownloading();
        nbm.resetToFactorySettings();
        nbm.writeToFile();
        nbm.convertCelsiusToFahrenheit();
        nbm.evaluateMathExpression();
        nbm.determineWinner();
        nbm.findBook();
    }

    public void getBooleanMethods(BooleanMethods bm) {
        System.out.println();
        bm.isRunning();
        bm.isDeletedFile();
        bm.hasUniqueDigits();
        bm.isLetter();
        bm.hasEqualDigits();
        bm.hasRemainingAttempts();
        bm.isEmptyStringOrSpaces();
        bm.isEvenNumber();
        bm.isValidPath();
        bm.isExistFile();
    }
}


