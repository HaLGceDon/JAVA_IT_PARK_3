package ru.itpark;

public class DigitsTask implements Runnable{

    private char charText[];
    private String text;

    DigitsTask(String text) {
        this.text = text;
        this.charText = new char[100];
    }


      @Override
      public void run() {
         charText = text.toCharArray();
         for (int i = 0; i < charText.length; i++) {
             if (charText[i] > 47 & charText[i] < 58) {
                 System.out.println(charText[i]);
             }
          }
      }


}
