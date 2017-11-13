package com.company;


public class MainLinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        System.out.println("Add To Begin: ");
        for (int i = 0; i < 6; i++) {
           list.addToBegin(i + 1);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();


        System.out.println("Add to end: ");
        for (int i = 0; i < 5; i++) {
            list.addToEnd(i + 1);
        }
        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        System.out.println("Search by index 2: " + list.searchByIndex(2));

        System.out.println("Amount of elements: " + list.amontOfElement());

        System.out.println("Delete last element: ");
        list.delete();
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();

        System.out.println("Delete by index 2: ");
        list.deleteByindex(2);
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println();

        System.out.println("Add by index 2, element 9: ");
        list.addByIndex(2, 9);
        Iterator iterator4 = list.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next() + " ");
        }
        System.out.println();

        System.out.println("Delete by element 1: ");
        list.deleteByElements(9);
        Iterator iterator5 = list.iterator();
        while (iterator5.hasNext()) {
            System.out.print(iterator5.next() + " ");
        }
        System.out.println();

        System.out.println("Expand list: ");
        list.expandList();
        Iterator iterator6 = list.iterator();
        while (iterator6.hasNext()) {
            System.out.print(iterator6.next() + " ");
        }
        System.out.println();


    }
}
