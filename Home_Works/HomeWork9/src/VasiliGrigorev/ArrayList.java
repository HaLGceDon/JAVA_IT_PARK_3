package VasiliGrigorev;



public class ArrayList implements List {

    private int count = 0;
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




    public class ArrayIterator implements Iterator {
        private int index = 0;
        @Override
        public int next() {
            int nResult = list[index];
            index++;
            return nResult;
        }


        @Override
        public boolean hasNext()  {
            if (index < list.length) {
                return true;
            } else return false;
        }
    }

    Iterator iterator = new ArrayIterator();


    @Override
    public int returnIterator() {
       return iterator.next();
    }

    @Override
    public boolean isIterator() {
        return iterator.hasNext();
    }


}