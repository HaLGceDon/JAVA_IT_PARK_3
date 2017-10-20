package VasiliGrigorev;


public class Main {

    public static void main(String[] args) {

       List list = new ArrayList();

       for (int i = 0; i < 10; i++){
           list.add(i);
       }

       list.delete(0);
       list.addByIndex(0, 9);

       System.out.println(list.searchByIndex(0));

      for (int i = 0;list.isIterator()==true; i++) {
           System.out.print(list.returnIterator() + " ");
       }


    }
}
