package com.company;

public class LinkedList implements List {

    private Node head;
    private int count;



    public LinkedList() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public void addToEnd(int element) {
        Node newNode = new Node(element);
        Node previousNode = null;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            previousNode = iterator.currentNode;
            iterator.next();
        }
        previousNode.next = newNode;
        count++;
    }

    public void addToBegin(int element) {
        // создали узел для элемента
        Node newNode = new Node(element);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
        count++;
    }

    @Override
    public void deleteByindex(int i) {
        Node node = head;
        Node next = node.next;
        for (int k = 0; k < i; k++){
            node = next;
            next = next.next;
        }
        node.value = next.value;
        node.next = next.next;
        count--;
    }

    @Override
    public void delete() {
        LinkedListIterator iterator = new LinkedListIterator();
        int k = 0;
        Node deleteNode = null;
        while (iterator.hasNext()) {
            if (k == count - 2) {
                deleteNode = iterator.currentNode;
            }
            k++;
            iterator.next();
        }
        deleteNode.next = null;
        count--;
    }

    @Override
    public int searchByIndex(int a) {
        LinkedListIterator iterator = new LinkedListIterator();
        int k = 0;
        int result = 0;
        while (iterator.hasNext()) {
            if (k == a) {
                result = iterator.next();
            }
            iterator.next();
            k++;
        }
        return result;
    }

    @Override
    public void addByIndex(int i, int a) {
        Node newNode = new Node(a);
        Node node = head;
        Node next = node.next;
        for (int k = 0; k < i - 1; k++){
            node = next;
            next = next.next;
        }
        node.next = newNode;
        newNode.next = next;
        count++;

    }

    @Override
    public int amontOfElement() {
        return count;
    }

    @Override
    public void expandList() {
        Node node = head;
        Node expandNode = null;
        while (node != null) {
            Node next = node.next;
            node.next = expandNode;
            expandNode = node;
            node = next;
        }
        head = expandNode;
    }

    @Override
    public void deleteByElements(int a) {
        Node newNode = head;
        while (newNode.next != null) {
            if (newNode.next.value == a) {
                newNode.next = newNode.next.next;
            }
            else newNode = newNode.next;
        }
        count--;
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
        public int next() {
            int element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }

        @Override
        public boolean hasNext() {

            return currentNode != null;
        }
    }
    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
