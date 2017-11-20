package ru.itpark;

public class HumanAgeComporator implements Comporator<Human> {

    @Override
    public int compare(Human a, Human b) {
        return a.getAge() - b.getAge();
    }
}
