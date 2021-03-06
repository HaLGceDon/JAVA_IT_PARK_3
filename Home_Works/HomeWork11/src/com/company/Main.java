package com.company;

import com.company.List.ArrayList;
import com.company.List.Iterator;
import com.company.List.LinkedList;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        DataReader reader = new DataReader("input.txt");
        String word = reader.readString();
        DataReader numberReader = new DataReader("input.txt");
        int number = numberReader.readInteger();

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            LinkedList linkedList = new LinkedList();
            arrayList.addByIndex(i, linkedList);
        }
        while (number != 0) {
            Human human = new Human(word, number);
            LinkedList newList = new LinkedList();
            newList = (LinkedList) arrayList.searchByIndex(number);
            newList.addToBegin(human);
            number = numberReader.readInteger();
            word = reader.readString();
        }

        Iterator iterator = arrayList.iterator();
        LinkedList concatLnkedList = new LinkedList();
        while (iterator.hasNext()) {
            LinkedList newLinkedList  = (LinkedList) iterator.next();
            concatLnkedList.concat(newLinkedList);
        }

        Iterator printIterator = concatLnkedList.iterator();
        while (printIterator.hasNext()) {
            Human printHuman = (Human) printIterator.next();
            System.out.print(printHuman.getName() + " - " + printHuman.getAge() + ", ");
        }

   //     Iterator iterator = arrayList.iterator();
   //     while (iterator.hasNext()) {
   //         System.out.println();
   //         LinkedList printList = new LinkedList();
   //         printList = (LinkedList) iterator.next();
   //         Iterator iteratorPrintList = printList.iterator();
   //         while (iteratorPrintList.hasNext()) {
   //             Human printHuman = (Human) iteratorPrintList.next();
   //             System.out.print(printHuman.getName() + " - " + printHuman.getAge() + ", ");
   //
   //         }
   //         System.out.println();
   //
   //
   //     }
    }
}