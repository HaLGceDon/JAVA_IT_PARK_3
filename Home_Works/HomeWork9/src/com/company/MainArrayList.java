package com.company;


public class MainArrayList {

    public static void main(String[] args) {
        List list = new ArrayList();

        System.out.println("AddToEnd elements 1 - 7: ");
        for (int i = 0; i < 7; i++) {
            list.addToEnd(i + 1);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("Search by index 2: " + list.searchByIndex(2));

        System.out.println("Delete by index 1: ");
        list.deleteByindex(1);
        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        System.out.println("Add by index 1 element 5: ");
        list.addByIndex(1, 5);
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();

        System.out.println("Add to begin 7: ");
        list.addToBegin(7);
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println();

        System.out.println("Delete by element 5: ");
        list.deleteByElements(5);
        Iterator iterator4 = list.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next() + " ");
        }
        System.out.println();
        System.out.println(list.amontOfElement());

        System.out.println("Expand list: ");
        list.expandList();
        Iterator iterator5 = list.iterator();
        while (iterator5.hasNext()) {
            System.out.print(iterator5.next() + " ");
        }

        System.out.println();
        System.out.println("Amount of elements: " + list.amontOfElement());

        System.out.println("Delete");
        list.delete();
        Iterator iterator6 = list.iterator();
        while (iterator6.hasNext()) {
            System.out.print(iterator6.next() + " ");
        }
    }
}
