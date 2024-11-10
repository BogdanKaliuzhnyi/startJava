package lesson_2;

public class BooleanMethods {
    public boolean isDeletedFile() {
        System.out.println(MethodNameInfo.getName() + "() -> файл удален?");
        return true;
    }

    public boolean isEmptyStringOrSpaces() {
        System.out.println(MethodNameInfo.getName() + "() -> введена пустая строка или пробелы?");
        return false;
    }

    public boolean isEvenNumber() {
        System.out.println(MethodNameInfo.getName() + "() -> выпало четное число?");
        return false;
    }

    public boolean isExistFile() {
        System.out.println(MethodNameInfo.getName() + "() -> файл существует?");
        return false;
    }

    public boolean isLetter() {
        System.out.println(MethodNameInfo.getName() + "() -> была введена буква?");
        return true;
    }

    public boolean isRunning() {
        System.out.println(MethodNameInfo.getName() + "() -> программа выполняется?");
        return true;
    }

    public boolean isValidPath() {
        System.out.println(MethodNameInfo.getName() + "() -> путь к файлу действителен?");
        return true;
    }

    public boolean hasEqualDigits() {
        System.out.println(MethodNameInfo.getName() + "() -> есть равные цифры?");
        return false;
    }

    public boolean hasRemainingAttempts() {
        System.out.println(MethodNameInfo.getName() + "() -> остались еще попытки?");
        return true;
    }

    public boolean hasUniqueDigits() {
        System.out.println(MethodNameInfo.getName() + "() -> последовательность содержит уникальную цифру?");
        return false;
    }
}