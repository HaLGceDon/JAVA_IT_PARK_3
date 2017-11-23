package ru.itpark;

public class TextViewer {

    // не обязательно Runnable
    private Runnable tasks[];
    private int tasksCount;

    private String text;

    public TextViewer() {
        this.tasks = new Runnable[5];
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addTask(Runnable task) {
        tasks[tasksCount] = task;
        tasksCount++;
    }

    public void process() {
        for (int i = 0; i < tasksCount; i++) {
            new Thread(tasks[i]).start();
        }

    }




    public String getText() {
        return text;
    }
}