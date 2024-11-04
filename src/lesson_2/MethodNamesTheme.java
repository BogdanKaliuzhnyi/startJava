package lesson_2;

public class MethodNamesTheme {
    public static void main(String[] args) {
        int u = 9;

        MethodNamesTheme dd = new MethodNamesTheme();
        dd.myMethod();
    }
    public static void myMethod() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String methodName = stackTraceElements[1].getMethodName();

        System.out.println(methodName);
    }
}

class A {
    void getLongestWordJavaBook(){
        //System.out.println(myMethod());
    }
}

class B {
}

class C {
}

class D {
}
