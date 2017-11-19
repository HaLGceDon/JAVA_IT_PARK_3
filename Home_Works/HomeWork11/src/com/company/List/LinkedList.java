package com.company.List;



public class LinkedList {
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


    public void concat (LinkedList otherList) {
        Iterator iterator = this.iterator();
        Node lastNode = this.head;
        Node otherNode = otherList.head;
        if (this.head == null) {
            this.head = otherList.head;
        }
        else {
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = otherList.head;
        }
    }



    public void addToBegin(Object object) {
        Node newNode = new Node(object);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
        count++;

    }





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
