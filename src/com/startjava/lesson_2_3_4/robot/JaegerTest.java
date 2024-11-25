package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger j1 = new Jaeger();
        j1.setModelName("Gipsy Danger");
        j1.setMark("Mark-3");
        j1.setOrigin("USA");
        j1.setHeight(79.25f);
        j1.setWeight(1.98f);
        j1.setSpeed(7);
        j1.setStrength(8);
        j1.setArmor(6);

        Jaeger j2 = new Jaeger("Crimson Typhoon" , "Mark-4", "China", 76.2f,
                1.72f, 9, 8, 6);

        j1.move(j1.getSpeed());
        j2.move(j2.getSpeed());
        j1.isActiveDrift();
        j2.isActiveDrift();
        System.out.println(j1.scanKaiju());
        j2.useCannon();
    }
}