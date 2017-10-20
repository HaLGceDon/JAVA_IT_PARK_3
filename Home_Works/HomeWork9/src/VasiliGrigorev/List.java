package VasiliGrigorev;

public  interface List {
    void add(int a);
    void delete(int i);
    int searchByIndex(int a);
    void addByIndex(int i, int a);
    int returnIterator();
    boolean isIterator();
}
