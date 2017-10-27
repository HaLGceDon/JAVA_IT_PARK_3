package VasiliGrigorev;


public class MainArrayList {

    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 9; i++) {
            list.addToEnd(i + 1);
        }


        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        list.delete(1);


        System.out.println(list.searchByIndex(2));


        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();
        list.addByIndex(1, 5);
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();

        list.addToBegin(7);
        Iterator iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println();

        list.deleteByElements(5);
        Iterator iterator4 = list.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next() + " ");
        }
        System.out.println();
        System.out.println(list.amontOfElement());


    }
}
