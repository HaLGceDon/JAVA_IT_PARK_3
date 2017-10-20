package VasiliGrigorev;



public class ArrayList implements List, Iterator {

    private  int count = 0;
    int list[] = new int[10];

    @Override
    public void add(int a) {
        list[count] = a;
        count++;
    }

    @Override
    public void delete(int i) {
        list[i] = 0;

    }

    @Override
    public int searchByIndex(int a) {
        int searchResult = list[a];
        return searchResult;
    }

    @Override
    public void addByIndex(int i, int a) {
        list[i] = a;
    }


    @Override
    public void returnIterator() {
        returnIterator();
    }

    @Override
    public int next() {
        int nextResult = list[count];
        count++;
        return nextResult;
    }

    @Override
    public boolean hasNext() {
        if (count < list.length) {
        return true; }
        else return false;
    }
}
