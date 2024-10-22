package lesson_2;

public class WolfTest {
    public static void main(String[] args) {
        Wolf alpha = new Wolf();
        alpha.sex = "Самка";
        alpha.name = "Сэдди";
        alpha.weight = 13.7f;
        alpha.age = 4;
        alpha.colour = "Тёмно-серый";

        System.out.println("Пол волка: " + alpha.sex);
        System.out.println("Кличка волчицы : " + alpha.sex);
        System.out.println("Вес волчицы : " + alpha.sex + " кг");
        System.out.println("Возраст волчицы : " + alpha.sex + " лет");
        System.out.println("Окрас волчицы : " + alpha.sex);

        alpha.walk();
        alpha.sit();
        alpha.run();
        alpha.howl();
        alpha.hunt();
    }
}
