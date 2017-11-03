package com.company.List;

public class ArrayList implements List {

    private int count = 0;
    private Object arrayList[];

    public ArrayList() {
        this.arrayList = new Object[100];
        this.count = 0;

    }



    public void addByIndex(int i, Object object) {
       arrayList[i] = object;
       count++;
    }

    @Override
    public void concat(LinkedList otherList) {
        System.out.println("не определено");
    }

    public Object searchByIndex(int a) {
        Object searchResult = arrayList[a];
        return searchResult;
    }


    @Override
    public void addToBegin(Object object) {
        if (count < arrayList.length) {
            for (int i = count; i > 0; i--) {
                arrayList[i] = arrayList[i-1];
            }
            count++;
            arrayList[0] = object;
        }

    }

    @Override
    public Iterator iterator() {
        return new ArrayItearator();
    }



    public class ArrayItearator implements Iterator {
        private int index = 0;
        public ArrayItearator() { index = 0; }
        @Override
        public Object next() {
            Object nResult = arrayList[index];
            index++;
            return nResult;
        }


        @Override
        public boolean hasNext() {
            return index < count;
        }


    }
}
