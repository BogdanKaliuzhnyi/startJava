package com.startjava.lesson_2_3.method.naming;

public class BooleanMethods {
    public boolean isRunning() {
        System.out.print(MethodNameInfo.getName() + "() -> программа выполняется далее или завершается? ");
        return true;
    }

    public boolean isDeletedFile() {
        System.out.print(MethodNameInfo.getName() + "() -> удалился ли файл на жестком диске или флешке? ");
        return true;
    }

    public boolean hasUniqueDigits() {
        System.out.print(MethodNameInfo.getName() + "() -> последовательность содержит уникальную цифру? ");
        return false;
    }

    public boolean isLetter() {
        System.out.print(MethodNameInfo.getName() + "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.print(MethodNameInfo.getName() + "() -> в проверяемых числах, есть равные цифры? ");
        return true;
    }

    public boolean hasAttempts() {
        System.out.print(MethodNameInfo.getName() + "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }

    public boolean isBlank() {
        System.out.print(MethodNameInfo.getName() + "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.print(MethodNameInfo.getName() +
                "() -> на кубике, который бросил компьютер, выпало четное число? ");
        return false;
    }

    public boolean isValidPath() {
        System.out.print(MethodNameInfo.getName() + "() -> путь до файла, который вы ищите на ssd, действительный? ");
        return true;
    }

    public boolean isExistFile() {
        System.out.print(MethodNameInfo.getName() + "() -> файл по указанному адресу существует? ");
        return false;
    }
}