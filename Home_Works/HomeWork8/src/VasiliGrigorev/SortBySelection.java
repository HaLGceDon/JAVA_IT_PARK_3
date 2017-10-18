package VasiliGrigorev;

public class SortBySelection implements Sorter {

    @Override
    public void sorter(Comporator comporator, Human[] humans) {
        for (int i = 0; i < humans.length; i++) {
            Human min = humans[i];
            int indexOfMinHuman = i;
            for (int j = i; j < humans.length; j++) {
                if (comporator.compare(humans[j], min) < 0) {
                    min = humans[j];
                    indexOfMinHuman = j;
                }
            }
            Human temp = humans[i];
            humans[i] = min;
            humans[indexOfMinHuman] = temp;
        }
    }

}
