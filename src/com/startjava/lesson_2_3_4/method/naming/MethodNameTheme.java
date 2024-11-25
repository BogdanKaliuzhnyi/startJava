package com.startjava.lesson_2_3_4.method.naming;

public class MethodNameTheme {
    public static void main(String[] args) {
        MethodNameTheme mnt = new MethodNameTheme();
        mnt.doNonBooleanMethods();
        mnt.doBooleanMethods();
    }

    private void doNonBooleanMethods() {
        NonBooleanMethods nbm = new NonBooleanMethods();
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
        nbm.inputMathExpression();
        nbm.determineWinner();
        nbm.findBook();
    }

    private void doBooleanMethods() {
        BooleanMethods bm = new BooleanMethods();
        System.out.println("\n" + bm.isRunning());
        System.out.println(bm.isDeletedFile());
        System.out.println(bm.hasUniqueDigits());
        System.out.println(bm.isLetter());
        System.out.println(bm.hasEqualDigits());
        System.out.println(bm.hasAttempts());
        System.out.println(bm.isBlank());
        System.out.println(bm.isEvenNumber());
        System.out.println(bm.isValidPath());
        System.out.println(bm.isExistFile());
    }
}


