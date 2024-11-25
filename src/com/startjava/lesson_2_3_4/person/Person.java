package com.startjava.lesson_2_3_4.person;

public class Person {
    String sex = "Мужской";
    String name = "Бобби";
    float height = 1.84f;
    float weight = 88.5f;
    int age = 27;

    void walk() {
        System.out.println(name + " решил немного пройтись по окрестностям.");
    }

    void sit() {
        System.out.println(name + " немного устал и присел отдохнуть.");
    }

    void run() {
        System.out.println(name + " внезапно побежал.");
    }

    void speak() {
        System.out.println(name + " произносит воодушевляющую речь.");
    }

    void learnJava() {
        System.out.println(name + " продолжил изучать Java.");
    }
}


