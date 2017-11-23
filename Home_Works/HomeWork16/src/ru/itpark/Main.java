package ru.itpark;

public class Main {

    public static void main(String[] args) {
        TextViewer viewer = new TextViewer();
        String text = "Hello, do you 1234: tel{}{| me 567890 dollars?";
        viewer.setText(text);
        viewer.addTask(new LettersTask(text));
        viewer.addTask(new DigitsTask(text));
        viewer.addTask(new PmTask(text));
        viewer.process();

    }
}
