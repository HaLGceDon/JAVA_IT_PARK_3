package ru.itpark;

public class PmTask implements Runnable {

    private char charText[];
    private String text;

    PmTask(String text) {
        this.text = text;
        this.charText = new char[100];
    }

    @Override
    public void run() {
        charText = text.toCharArray();
        int k = 0;
        for (int i = 0; i < charText.length; i++) {
            if (charText[i] > 31 & charText[i] < 48 || charText[i] > 57 & charText[i] < 65
                    || charText[i] > 90 & charText[i] < 97 || charText[i] > 122 & charText[i] < 127) {
                System.out.print(charText[i]);
                k++;
                if (k % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }


}
