package VasiliGrigorev;



public class ArrayList implements List {
    private int count = 0;
    private int arrayList[];

    public ArrayList() {
        this.arrayList = new int[10];
        this.count = 0;
    }

    @Override
    public void addToEnd(int a) {
        if (count < arrayList.length) {
            arrayList[count] = a;
            count++;
        }
        else System.out.println("Недостаточно места.");
    }

    @Override
    public void addToBegin(int a) {
        if (count < arrayList.length) {
            for (int i = count; i > 0; i--) {
                arrayList[i] = arrayList[i-1];
            }
            count++;
            arrayList[0] = a;
        }
        else System.out.println("Недостаточно места.");

    }

    @Override
    public void delete(int i) {
        for (int k = i; k < count; k++ ){
            arrayList[k] = arrayList[k+1];
        }
        count--;
    }

    @Override
    public int searchByIndex(int a) {
        int searchResult = arrayList[a];
        return searchResult;
    }

    @Override
    public void addByIndex(int i, int a) {
        if (count < arrayList.length) {
            int temp;
            int j = i;
            int k = count;
            while (j < arrayList.length - 1){
                arrayList[k] = arrayList[k - 1];
                k = k -1;
                j = j +1;
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
        public ArrayItearator() { index = 0; }
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