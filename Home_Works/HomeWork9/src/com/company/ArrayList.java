package com.company;



public class ArrayList implements List {
    private int count = 0;
    private int MAX_SIZE = 10;
    private int arrayList[];

    public ArrayList() {
        this.arrayList = new int[MAX_SIZE];
        this.count = 0;
    }



    @Override
    public void addToEnd(int a) {
        if (count < MAX_SIZE) {
            arrayList[count] = a;
            count++;
        }
        else System.out.println("Недостаточно места.");
    }

    @Override
    public void addToBegin(int a) {
        if (count < MAX_SIZE) {
            for (int i = count; i > 0; i--) {
                arrayList[i] = arrayList[i-1];
            }
            count++;
            arrayList[0] = a;
        }
        else System.out.println("Недостаточно места.");

    }

    @Override
    public void deleteByindex(int i) {
        for (int k = i; k < count; k++ ){
            arrayList[k] = arrayList[k+1];
        }
        count--;
    }

    @Override
    public void delete() {
        int k = count;
        if (k > 0) {
            arrayList[k] = 0;
            count--;
        }
        else System.out.println("Нечего удалять");

    }

    @Override
    public int searchByIndex(int a) {
        return arrayList[a];
    }

    @Override
    public void addByIndex(int i, int a) {
        if (count < MAX_SIZE) {
            for (int k = MAX_SIZE - 1; k > i; k--) {
                arrayList[k] = arrayList[k - 1];
            }

            arrayList[i] = a;
            count++;
        }
        else System.out.println("Недостаточно места");
    }

    @Override
    public int amontOfElement() {
        return count;
    }

    @Override
    public void expandList() {
        int k = count;
        int expandList[] = new int[k];
        for (int i =0; i < k; i++) {
            expandList[k - i - 1] = arrayList[i];
        }
        for (int i =0; i < k; i++) {
            arrayList[i] =  expandList[i];
        }
    }

    @Override
    public void deleteByElements(int a) {
        for (int k = 0; k < count; k++ ){
            if (arrayList[k] == a) {

                for (int i = k; i < count - 1; i++ ){
                    arrayList[i] = arrayList[i+1];
                }
                count--;
            }
        }

    }

    @Override
    public Iterator iterator() {
        return new ArrayItearator();
    }



    public class ArrayItearator implements Iterator {
        private int index = 0;
        public ArrayItearator() {
            index = 0;
        }

        @Override
        public int next() {
            int nResult = arrayList[index];
            index++;
            return nResult;
        }


        @Override
        public boolean hasNext() {
            return index < count;
        }


    }

}