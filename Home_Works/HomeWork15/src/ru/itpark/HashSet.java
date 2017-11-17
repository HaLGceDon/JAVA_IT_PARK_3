package ru.itpark;

public class HashSet <V> {

        private static class Node<E> {
            private E value;
            private Node <E> next;
        }

        private Node<V> buckets[];
        int count = 0;

        public HashSet() {

            this.buckets = new Node[16];
        }

        public void put (V value){
            int hash = value.hashCode();
            int index = hash & (buckets.length - 1);
            if (buckets[index] == null) {
                Node<V> newNode = new Node<>();
                newNode.value = value;
                buckets[index] = newNode;
            } else {
                Node<V> current = buckets[index];
                while (current.next != null) {
                    if (current.value.equals(value)) {
                        current.value = value;
                        return;
                    }
                    current = current.next;
                }
                if (current.value.equals(value)) {
                    current.value = value;
                    return;
                }
                Node<V> newNode = new Node<>();
                newNode.value = value;
                current.next = newNode;
            }

        }



        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Node))
                return false;
            Node otherNode = (Node) other;
            return
                    (other.equals(otherNode.value))
                            && ((otherNode == null)
                            ? otherNode.value == null
                            : other.equals(otherNode.value));
        }


    public V get(V key) {
        int hash =  key.hashCode();
        int index = hash & (buckets.length - 1);

        Node<V> current = buckets[index];

        while (current != null) {
            if (current.value.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }



    public Iterator <V> iterator() {
        return new Iterator <V> ();
    }

    private class Iterator <V> implements ru.itpark.Iterator{

        private Node <V> currentNode;

        Iterator() {
                currentNode = (Node) buckets[1];
        }


        public V next() {
            V element =  currentNode.value;
            currentNode = currentNode.next;
            return element;
        }


        public boolean hasNext() {

            return currentNode != null;
        }
    }



}
