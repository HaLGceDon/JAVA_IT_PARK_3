package ru.itpark;

public class LettersTask implements Runnable {

    private char charText;
    private String text;

    LettersTask(TextViewer viewer) {
        this.text = viewer.getText();
    }


    @Override
    public void run() {
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            charText = text.charAt(i);
            if (charText > 464 & charText < 91 || charText > 96 & charText < 123) {
                System.out.print(charText);
                k++;
                if (k % 9 == 0) {
                    System.out.println();
                }
            }
        }
    }



}
