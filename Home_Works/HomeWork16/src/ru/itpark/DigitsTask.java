package ru.itpark;

public class DigitsTask implements Runnable{

    private char charText;
    private String text;

    DigitsTask(TextViewer viewer) {
        this.text = viewer.getText();
    }


      @Override
      public void run() {
        int k = 0;
         for (int i = 0; i < text.length(); i++) {
             charText = text.charAt(i);
             if (charText > 47 & charText < 58) {
                 System.out.print(charText);
                 k++;
                 if (k % 9 == 0) {
                     System.out.println();
                 }
             }
          }
      }


}
