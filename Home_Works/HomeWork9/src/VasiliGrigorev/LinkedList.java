package VasiliGrigorev;

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
        Node lastNode = null;
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            lastNode = iterator.currentNode;
            iterator.next();
        }
        lastNode.next = newNode;
        count++;


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
    public void deleteByIndex (int i) {
        if (head != null) {
            if (head.next != null) {
                Node current = head;
                Node next = current.next;
                while (next.next != null) {
                    current = next;
                    next = current.next;
                }
                current.next = null;
            } else {
                head = null;
            }
            count--;
        } else {
            System.out.println("пустo");
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public int searchByIndex(int i) {

        return 0;
    }

    @Override
    public void addByIndex(int i, int a) {
        Node newNode = new Node(a);
        Node current = head;
        Node next = current.next;
        if (i != 0) {
            for (int k = 0; k < i - 1; i++) {
                if (current.next != null) {
                    current = next;
                    next = current.next;
                }
            }
            current.next = newNode;
            newNode.next = next;
        } else {
            newNode.value = head.value;
            head.next = newNode;
            head.value = a;
            newNode.next = next;
        }
        count++;
    }

    @Override
    public int amontOfElement() {
        return 0;
    }

    @Override
    public void expandList() {
        Node temp = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = temp;
            temp = current;
            current = next;
        }
        head = temp;
    }

    @Override
    public void deleteByElements(int a) {

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
