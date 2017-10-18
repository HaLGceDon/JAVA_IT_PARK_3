package VasiliGrigorev;

public class ComparatorByWeight implements Comporator {
    @Override
    public int compare(Human a, Human b) {
        return a.getWeight() - b.getWeight();
    }
}
