package VasiliGrigorev;

public class SorterBubles implements Sorter {
    @Override
    public void sorter(Comporator comporator, Human[] humans) {
        for (int i = humans.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comporator.compare(humans[j], humans[j+1]) > 0) {
                    Human temp = humans[j];
                    humans[j] = humans[j+1];
                    humans[j+1] = temp;
                }
            }
        }

    }
}
