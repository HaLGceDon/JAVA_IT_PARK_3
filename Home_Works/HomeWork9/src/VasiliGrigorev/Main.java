package VasiliGrigorev;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");



        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }


    }
}
