package com.company;

import com.company.List.Iterator;
import com.company.List.LinkedList;
import com.company.List.List;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        DataReader reader = new DataReader("input.txt");
        String word = reader.readString();
        DataReader numberReder = new DataReader("input.txt");
        int number = numberReder.readInteger();

        List ageList[] = new LinkedList[100];
        for (int i = 0; i < 100; i++) {
            ageList[i] = new LinkedList();
       }

        while (number != 0) {
            for (int i = 0; i < 100; i++) {

                if (number == i) {
                    ageList[i].addToBegin(word);
                }
            }

           number = numberReder.readInteger();
           word = reader.readString();
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(i + " - ");
            Iterator iterator = ageList[i].iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ", ");
            }
            System.out.println();
        }
    }
}