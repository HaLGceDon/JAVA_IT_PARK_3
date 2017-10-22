package VasiliGrigorev;

public  interface List {
    void addToEnd(int a);
    void addToBegin(int a);
    void delete(int i);
    int searchByIndex(int a);
    void addByIndex(int i, int a);
    int amontOfEltmrnt ();
    void expandList ();
    void deleteByEltments (int a);

    Iterator iterator();
}
