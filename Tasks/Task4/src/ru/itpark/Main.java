package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int iMin;
        int iMax;
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int array[] = new int[arraySize];


        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min);
            {
                min = array[i];
                int iMin = i;
            }
            if (array[i] > max);
            {
                max = array[i];
                int iMax = i;
            }
            int Zamena = array[iMin];
            array[iMin] = array[iMax];
            array[iMax]

        }
        System.out.print(max + " " + min);
    }
}