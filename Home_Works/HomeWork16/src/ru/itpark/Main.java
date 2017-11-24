package ru.itpark;

public class Main {

    public static void main(String[] args) {
        TextViewer viewer = new TextViewer();
        String text = "The five boxing wizards jump quickly. Hello, do you want: <>?!@#$%^&*()/*_,.'+=- or 1234567890? Can i help you? ";
        viewer.setText(text);
        viewer.addTask(new LettersTask(viewer));
        viewer.addTask(new DigitsTask(viewer));
        viewer.addTask(new PmTask(viewer));
        viewer.process();
    }
}
