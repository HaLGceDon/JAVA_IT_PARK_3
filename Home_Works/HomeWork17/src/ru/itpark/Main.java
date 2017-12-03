package ru.itpark;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int array[][] = new int[n][m];

        Random random = new Random();

        int arrayHelpRandom[] = new int[n*m];

        for (int i= 0; i < n*m; i++) {
            arrayHelpRandom[i] = i;
        }

        for (int i= 0; i < n*m; i++) {
            int k = random.nextInt(n*m);
            int temp = arrayHelpRandom[i];
            arrayHelpRandom[i] = arrayHelpRandom[k];
            arrayHelpRandom[k] = temp;
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    array[i][j] = arrayHelpRandom[j + m*i];
                }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();

        }

        int number = scanner.nextInt();

        ThreadPool threadPool = new ThreadPool(5);

   //    threadPool.submitTask(() -> {
   //        for (int i = 0; i < n; i++) {
   //            for (int j = 0; j < m; j++) {
   //                if (number == array[i][j]) {
   //                    System.out.println(i + "," + j);
   //                }
   //
   //            }
   //        }
   //    });

       for (int i = 0; i < n; i++) {
           final int k = i;
               threadPool.submitTask(() -> {
                    for (int j = 0; j < m; j++) {
                        if (number == array[k][j]) {
                            System.out.println(k + "," + j);
                        }
   
                    }
               });
       }
     ExecutorService service = Executors.newFixedThreadPool(n);

       for (int i = 0; i < n; i++) {
           final int k = i;
           service.submit(new Runnable() {
               @Override
               public void run() {
                   for (int j = 0; j < m; j++) {
                       if (number == array[k][j]) {
                           System.out.print(Thread.currentThread().getName() + " - ");
                           System.out.println(k + "," + j);
                       }
                   }
               }
           });
       }
   }
}
