package com.company.List;



public class LinkedList implements List {
    private Node head;
    private int count;

    private static class Node {
        private Object value;
        private Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }

    }

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void concat(LinkedList otherList) {


    }

    @Override
    public Object searchByIndex(int a) {
        return null;
    }

    @Override
    public void addToBegin(Object object) {
        Node newNode = new Node(object);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
        count++;

    }

    @Override
    public void addByIndex(int a, Object object) {
        System.out.println("gecnjq vtnjl");
    }



    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }



    private class LinkedListIterator implements Iterator {

        private Node currentNode;

        LinkedListIterator() {
            currentNode = head;
        }

        @Override
        public Object next() {
            Object element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }


}
