package ru.itpark;

public class PmTask implements Runnable {

    private char charText;
    private String text;

    PmTask(TextViewer viewer) {
        this.text = viewer.getText();
    }

    @Override
    public void run() {
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            charText = text.charAt(i);
            if (charText > 31 & charText < 48 || charText > 57 & charText < 65
                    || charText > 90 & charText < 97 || charText > 122 & charText < 127) {
                System.out.print(charText);
                k++;
                if (k % 9== 0) {
                    System.out.println();
                }
            }
        }
    }


}
