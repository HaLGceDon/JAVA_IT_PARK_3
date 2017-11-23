package ru.itpark;

public class LettersTask implements Runnable {

    private char charText[];
    private String text;

    LettersTask(String text) {
        this.text = text;
        this.charText = new char[100];
    }


    @Override
    public void run() {
        charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            if (charText[i] > 464 & charText[i] < 91 || charText[i] > 96 & charText[i] < 123) {
                System.out.println(charText[i]);
            }
        }
    }



}
