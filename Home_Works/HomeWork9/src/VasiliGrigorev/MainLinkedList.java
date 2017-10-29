package VasiliGrigorev;

public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToBegin(6);
        list.addToBegin(8);
        list.addToBegin(9);
        list.addToBegin(1);
        list.addToEnd(77);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
