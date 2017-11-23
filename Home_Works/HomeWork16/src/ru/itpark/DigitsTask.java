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
        int k = 0;
         charText = text.toCharArray();
         for (int i = 0; i < charText.length; i++) {
             if (charText[i] > 47 & charText[i] < 58) {
                 System.out.print(charText[i]);
                 k++;
                 if (k % 5 == 0) {
                     System.out.println();
                 }
             }
          }
      }


}
