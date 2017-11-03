package com.company.List;

public interface List {
    void addToBegin(Object object);
    void addByIndex(int a, Object object);
    void concat(LinkedList otherList);
    Object searchByIndex(int a);
    Iterator iterator();
}
