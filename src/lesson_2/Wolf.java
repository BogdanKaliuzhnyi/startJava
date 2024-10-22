package lesson_2;

public class Wolf {
    String sex;
    String name;
    float weight;
    int age;
    String colour;

    void walk() {
        System.out.println("Волк " + name + " идёт.");
    }

    void sit() {
        System.out.println("Волк " + name + " сидит.");
    }

    void run() {
        System.out.println("Волк " + name + " бежит очень быстро.");
    }

    void howl() {
        System.out.println("Волк " + name + " громко воет.");
    }

    void hunt() {
        System.out.println("Волк " + name + " проголодался и вышел на охоту.");
    }
}
