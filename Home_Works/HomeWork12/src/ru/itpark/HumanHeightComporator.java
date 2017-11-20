package ru.itpark;

public class HumanHeightComporator implements Comporator <Human> {

    @Override
    public int compare(Human a, Human b) {
        return a.getHeight() - b.getHeight();
    }
}
