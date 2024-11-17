package com.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf alpha = new Wolf();
        alpha.setSex("Самка");
        System.out.println("Пол волка: " + alpha.getSex());

        alpha.setNickname("Сэдди");
        System.out.println("Кличка волчицы: " + alpha.getNickname());

        alpha.setWeight(13.7f);
        System.out.println("Вес волчицы: " + alpha.getWeight()+ " кг");

        alpha.setAge(4);
        System.out.println("Возраст волчицы: " + alpha.getAge() + " лет");

        alpha.setColor("Темно-серый");
        System.out.println("Окрас волчицы: " + alpha.getColor());

        alpha.walk();
        alpha.sit();
        alpha.run();
        alpha.howl();
        alpha.hunt();
    }
}
