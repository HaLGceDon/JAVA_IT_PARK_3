package VasiliGrigorev;

public interface ListIterator <E>{
    void add(E obj);

    boolean hasNext();

    boolean hasPrevious();

    E next();

    E previous();

    int nextIndex();
    int previousIndex();
    void remove();
    void set(E obj);
}