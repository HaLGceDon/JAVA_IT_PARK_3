package VasiliGrigorev;

public class ComparatorByAge implements Comporator {
    @Override
    public int compare(Human a, Human b) {
        return a.getAge() - b.getAge();
    }
}
