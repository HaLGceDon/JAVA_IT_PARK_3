package ru.itpark;

public class Human implements Comparable <Human> {
    private String name;
    private int age;
    private int height;

    public Human(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Human that) {
        return this.age - that.age;
    }

    public String toString() {
        return name + " " + age + " " + height;
    }
}