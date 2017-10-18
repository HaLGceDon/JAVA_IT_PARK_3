package VasiliGrigorev;

public class ComparatotByHeight implements Comporator {
    @Override
    public int compare(Human a, Human b) {
        return a.getHeight() - b.getHeight();
    }
}
