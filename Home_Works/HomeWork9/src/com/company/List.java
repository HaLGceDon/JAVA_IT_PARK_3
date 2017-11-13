package com.company;

public  interface List {
    void addToEnd(int a);
    void addToBegin(int a);
    void deleteByindex(int i);
    void delete();
    int searchByIndex(int a);
    void addByIndex(int i, int a);
    int amontOfElement ();
    void expandList ();
    void deleteByElements (int a);

    Iterator iterator();
}
