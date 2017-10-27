package com.company.List;

public class LinkedList implements List {
    private Node head;
    private int count;

    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void addToBegin(String a) {
        Node newNode = new Node(a);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
        count++;

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
        public String next() {
            String element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
    }

    private static class Node {
        private String value;
        private Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }
}
