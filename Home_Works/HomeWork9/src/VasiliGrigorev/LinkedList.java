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
        // TODO: реализовать вставку в конец самостоятельно
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
    public void delete(int i) {

    }

    @Override
    public int searchByIndex(int a) {
        return 0;
    }

    @Override
    public void addByIndex(int i, int a) {

    }

    @Override
    public int amontOfElement() {
        return 0;
    }

    @Override
    public void expandList() {

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
