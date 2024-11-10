package lesson_2;

public class MethodNameInfo {
    public static String getName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}